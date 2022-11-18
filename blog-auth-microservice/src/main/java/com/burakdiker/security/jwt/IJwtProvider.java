package com.burakdiker.security.jwt;

import com.burakdiker.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;
import java.security.KeyFactory;

public interface IJwtProvider {

    KeyFactory getKeyFactory();


    //userPrincipal: username,password,roles
    String generateToken(UserPrincipal userPrincipal);

    //HEADER: bearer => 7
    String resolveToken(HttpServletRequest httpServletRequest);
    Authentication getAuthentication(HttpServletRequest httpServletRequest);

    boolean isValidateToken(HttpServletRequest httpServletRequest);
}
