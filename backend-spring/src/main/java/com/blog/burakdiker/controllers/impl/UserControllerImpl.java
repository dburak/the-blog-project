package com.blog.burakdiker.controllers.impl;

import com.blog.burakdiker.business.dto.UserDto;
import com.blog.burakdiker.business.services.IUserServices;
import com.blog.burakdiker.controllers.IUserController;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor


@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserControllerImpl implements IUserController {

    //injection services
    private final IUserServices services;


    //LIST
    @Override
    @GetMapping
    public ResponseEntity<List<UserDto>> listUsers() {
        return ResponseEntity.ok(services.listUser());
    }

    //CREATE
    @Override
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
        services.createUser(userDto);
        return ResponseEntity.ok(userDto);
    }

    //FIND
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUser(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(services.findUser(id));
    }

    //UPDATE
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(name = "id") Long id, @Valid @RequestBody UserDto userDto) {
        services.updateUser(id, userDto);
        return ResponseEntity.ok(userDto);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable(name = "id") Long id) {
        services.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
