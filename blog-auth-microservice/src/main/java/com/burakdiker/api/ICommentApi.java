package com.burakdiker.api;

import com.burakdiker.error.ApiResult;
import com.google.gson.JsonElement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICommentApi {
    //SAVE
    ApiResult saveComment(JsonElement jsonElement);

    //LIST
    ResponseEntity<List<?>> listComment();

    //FIND
    ResponseEntity<?> findComment(Long id);


    //DELETE
    ApiResult deleteComment(Long id);

    //UPDATE
    ApiResult updateComment(Long id,JsonElement jsonElement);
}
