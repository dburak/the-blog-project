package com.blog.burakdiker.business.services;

import com.blog.burakdiker.business.dto.UserDto;
import com.blog.burakdiker.data.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface IUserServices {

    UserDto entityToDto(UserEntity registerEntity);

    UserEntity dtoToEntity(UserDto registerDto);

    //CREATE
    UserDto createUser(UserDto registerDto);

    //LIST
    List<UserDto> listUser();

    //FIND
    UserDto findUser(Long id);

    //DELETE
    Map<String,Boolean> deleteUser(Long id);

    //UPDATE
    UserDto updateUser(Long id, UserDto registerDto);
}
