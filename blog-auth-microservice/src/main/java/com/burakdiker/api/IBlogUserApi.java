package com.burakdiker.api;

import com.burakdiker.error.ApiResult;
import com.google.gson.JsonElement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBlogUserApi {

    //SAVE
    ApiResult saveUser(JsonElement jsonElement);

    //LIST
    ResponseEntity<List<?>> listUser();

    //FIND
    ResponseEntity<?> findUser(Long id);

    //DELETE
    ApiResult deleteUser(Long id);

    //UPDATE
    ApiResult updateUser(Long id,JsonElement jsonElement);
}
