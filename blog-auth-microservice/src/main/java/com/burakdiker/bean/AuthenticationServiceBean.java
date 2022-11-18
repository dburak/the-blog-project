package com.burakdiker.bean;

import com.burakdiker.business.services.impl.AuthenticationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationServiceBean {

    @Bean
    public AuthenticationServiceImpl authenticationServiceMethodBean(){
        return new AuthenticationServiceImpl();
    }
}