package com.burakdiker.api;

import com.burakdiker.error.ApiResult;
import com.google.gson.JsonElement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBlogApi {
    //SAVE
    ApiResult saveBlog(JsonElement jsonElement);

    //LIST
    ResponseEntity<List<?>> listBlog();

    //FIND
    ResponseEntity<?> findBlog(Long id);


    //DELETE
    ApiResult deleteBlog(Long id);

    //UPDATE
    ApiResult updateBlog(Long id,JsonElement jsonElement);
}
