package com.burakdiker.api;

import com.burakdiker.error.ApiResult;
import com.google.gson.JsonElement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFavoriteApi {
    //SAVE
    ApiResult saveFavorite(JsonElement jsonElement);

    //LIST
    ResponseEntity<List<?>> listFavorite();

    //FIND
    ResponseEntity<?> findFavorite(Long id);


    //DELETE
    ApiResult deleteFavorite(Long id);

    //UPDATE
    ApiResult updateFavorite(Long id,JsonElement jsonElement);
}
