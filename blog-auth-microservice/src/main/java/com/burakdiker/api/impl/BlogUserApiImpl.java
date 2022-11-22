package com.burakdiker.api.impl;

import com.burakdiker.api.IBlogUserApi;
import com.burakdiker.business.services.IBlogUserService;
import com.burakdiker.error.ApiResult;
import com.google.gson.JsonElement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequiredArgsConstructor

@RestController
@RequestMapping("gateway/user")
public class BlogUserApiImpl implements IBlogUserApi {

    //Injection
    private final IBlogUserService blogUserService;
    private static final String PATH = "gateway/user";


    @Override
    @PostMapping
    public ApiResult saveUser(JsonElement jsonElement) {
        blogUserService.userSave(jsonElement);
        return new ApiResult(200, "Register Successfull", PATH);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<?>> listUser() {
        blogUserService.userList();
        return ResponseEntity.ok(blogUserService.userList());
    }

    @Override
    @GetMapping("/{userId}")
    public ResponseEntity<?> findUser(@PathVariable Long userId) {
        return ResponseEntity.ok(blogUserService.userFind(userId));
    }

    @Override
    @DeleteMapping("/{userId}")
    public ApiResult deleteUser(@PathVariable Long userId) {
        blogUserService.userDelete(userId);
        return new ApiResult(200, "Deleted", PATH);
    }

    @Override
    @PutMapping("/{userId}")
    public ApiResult updateUser(Long id, JsonElement jsonElement) {
        blogUserService.userUpdate(id,jsonElement);
        return new ApiResult(200, "Updated", PATH);
    }
}
