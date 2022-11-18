package com.burakdiker.security.jwt;

import com.burakdiker.security.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


//spring tarafında instance oluşturmak için
@Component
public class JwtProviderImpl implements IJwtProvider {


    private static final String JWT_TOKEN_PREFIX = "Bearer";
    private static final String JWT_HEADER_STRING = "Authorization";


    @Value("${authentication.jwt.expiration-ms}")
    private Long JWT_EXPIRATION_MS;

    // Genel anahtar
    private PublicKey jwtPublicKey;

    // Gizli anahtar
    private PrivateKey jwtPrivateKey;

    public JwtProviderImpl(
            @Value("${authentication.jwt.public-key}") String jwtPublicKeyStr,
            @Value("${authentication.jwt.private-key}") String jwtPrivateKeyStr) throws InvalidKeySpecException {
        try {

            KeyFactory keyFactory = getKeyFactory();


            Base64.Decoder decoder = Base64.getDecoder();

            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(decoder.decode(jwtPrivateKeyStr.getBytes()));

            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(decoder.decode(jwtPublicKeyStr.getBytes()));

            jwtPrivateKey = keyFactory.generatePrivate(privateKeySpec);
            jwtPublicKey = keyFactory.generatePublic(publicKeySpec);
        } catch (Exception e) {
            throw new RuntimeException("Invalid key specification ", e);
        }
    }



    @Override
    public KeyFactory getKeyFactory() {
        try {
            return KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unknow key generation algorithm ", e);
        }
    }


    @Override
    public String generateToken(UserPrincipal authentication) {
        String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining());
        return Jwts.builder().setSubject(authentication.getUsername())

                .claim("userId", authentication.getId())

                .claim("roles", authorities)

                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_MS))

                .signWith(jwtPrivateKey, SignatureAlgorithm.RS512)
                .compact();
    }


    @Override
    public String resolveToken(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader(JWT_HEADER_STRING);

        if (bearerToken != null && bearerToken.startsWith(JWT_TOKEN_PREFIX))
            return bearerToken.substring(7);
        return null;
    }


    @Override
    public Authentication getAuthentication(HttpServletRequest httpServletRequest) {
        String token = resolveToken(httpServletRequest);

        if (token == null)
            return null;

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtPublicKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();
        Long userId = claims.get("userId", Long.class);

        List<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
                .map(role -> role.startsWith("ROLE_") ? role : "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());


        UserDetails userDetails = new UserPrincipal(userId, username, null);
        Authentication kimlikDogrulama = username != null ? new UsernamePasswordAuthenticationToken(userDetails, null, authorities) : null;
        return kimlikDogrulama;
    }


    @Override
    public boolean isValidateToken(HttpServletRequest httpServletRequest) {
        String token = resolveToken(httpServletRequest);
        if (token == null)
            return false;


        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtPublicKey)
                .build()
                .parseClaimsJws(token)
                .getBody();



        if (claims.getExpiration().before(new Date()))
            return false;
        return true;
    }
}
