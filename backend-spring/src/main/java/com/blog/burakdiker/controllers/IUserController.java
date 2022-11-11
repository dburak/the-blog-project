package com.blog.burakdiker.controllers;

import com.blog.burakdiker.business.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUserController {

    //LIST
    ResponseEntity<List<UserDto>> listUsers();

    //CREATE
    ResponseEntity<?> createUser(UserDto registerDto);

    //FIND
    ResponseEntity<UserDto> findUser(Long id);

    //UPDATE
    ResponseEntity<UserDto> updateUser(Long id, UserDto userDto);

    //DELETE
    ResponseEntity <Map<String, Boolean>> deleteUser(Long id);

}
