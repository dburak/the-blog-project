package com.blog.burakdiker.business.services.impl;

import com.blog.burakdiker.bean.ModelMapperBean;
import com.blog.burakdiker.business.dto.UserDto;
import com.blog.burakdiker.business.services.IUserServices;
import com.blog.burakdiker.data.entity.UserEntity;
import com.blog.burakdiker.data.repository.IUserRepository;
import com.blog.burakdiker.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Log4j2

@Service
@Transactional
public class UserServicesImpl implements IUserServices {

    //injection
    private final IUserRepository repository;
    private final ModelMapperBean modelMapperBean;

    // model mapping
    @Override
    public UserDto entityToDto(UserEntity userEntity) {
        return modelMapperBean.modelMapperMethod().map(userEntity, UserDto.class);
    }

    @Override
    public UserEntity dtoToEntity(UserDto userDto) {
        return modelMapperBean.modelMapperMethod().map(userDto, UserEntity.class);
    }

    //CREATE
    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity registerEntity = dtoToEntity(userDto);
        repository.save(registerEntity);
        return userDto;
    }

    //LIST
    @Override
    public List<UserDto> listUser() {
        List<UserEntity> registerEntityList = repository.findAll();
        List<UserDto> dtoList = new ArrayList<>();
        for (UserEntity temp : registerEntityList) {
            UserDto entityToDto = entityToDto(temp);
            dtoList.add(entityToDto);
        }
        return dtoList;
    }

    //FIND
    @Override
    public UserDto findUser(Long id) {
        UserEntity registerEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id cannot be found"));
        UserDto entityToDto = entityToDto(registerEntity);
        return entityToDto;
    }

    //DELETE
    @Override
    public Map<String, Boolean> deleteUser(Long id) {
        UserEntity registerEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id cannot be found"));
        repository.delete(registerEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    //UPDATE
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        UserEntity registerEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id cannot be found"));
        if (registerEntity != null) {
            registerEntity.setId(userDto.getId());
            registerEntity.setUserName(userDto.getUserName());
            registerEntity.setPassword(userDto.getPassword());
            repository.save(registerEntity);
        }
        return userDto;
    }
}
