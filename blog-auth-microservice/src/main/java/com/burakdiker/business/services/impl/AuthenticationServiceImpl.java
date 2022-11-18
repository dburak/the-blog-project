package com.burakdiker.business.services.impl;

import com.burakdiker.business.services.IAuthenticationService;
import com.burakdiker.security.UserPrincipal;
import com.burakdiker.security.jwt.IJwtProvider;
import com.burakdiker.business.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AuthenticationServiceImpl implements IAuthenticationService {

    //injection
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private IJwtProvider iJwtProvider;

    @Override
    public String loginReturnJwt(UserDto userDto){
        //Authentication ==> UserDto username ve password vermek
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));

        // UserPrincipal
        UserPrincipal userPrincipal= (UserPrincipal) authentication.getPrincipal();

        //IJwtProvider
        return iJwtProvider.generateToken(userPrincipal);
    }
}