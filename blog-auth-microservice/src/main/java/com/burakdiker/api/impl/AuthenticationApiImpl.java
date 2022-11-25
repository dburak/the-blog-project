package com.burakdiker.api.impl;

import com.burakdiker.api.IAuthenticationApi;
import com.burakdiker.business.dto.UserDto;
import com.burakdiker.business.services.IAuthenticationService;
import com.burakdiker.business.services.IBlogUserService;
import com.burakdiker.business.services.IUserServices;
import com.burakdiker.data.entity.UserEntity;
import com.burakdiker.security.jwt.JwtProviderImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//lombok
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationApiImpl implements IAuthenticationApi {

    //Injection
    private final IAuthenticationService authenticationService;
    private final IUserServices userServices;


    private final  AuthenticationManager authenticationManager;
    private final JwtProviderImpl jwtUtils;


    //REGISTER
    // http://localhost:3333/api/authentication/register
    @Override
    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        // unique user
        if (userServices.findUsername(userDto.getUsername()).isPresent()) {
            userDto.setMessage("Username is already in use");
            return new ResponseEntity<>(userDto, HttpStatus.CONFLICT);
        }
        userServices.createUser(userDto);
        userDto.setMessage("Username is successfully registered.");
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    //LOGIN
    // http://localhost:3333/api/authentication/login
    @Override
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        //UserPrincipal userLoginDetails= (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //System.out.println(userLoginDetails);

        Optional<UserEntity> user = userServices.findUsername(userDto.getUsername());

        userDto.setMessage(authenticationService.loginReturnJwt(userDto));
        userDto.setId(user.get().getId());


        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
