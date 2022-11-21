package com.burakdiker.retrofit.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface IFavoriteServiceRequest {
    @POST("/api/v1/favorites")
    Call<JsonElement> favoriteSave(@Body JsonElement jsonElement);

    //LIST
    @GET("/api/v1/favorites")
    Call<List<JsonElement>> favoriteList();

    //FIND
    @GET("/api/v1/favorites/{favoriteId}")
    Call<JsonElement> favoriteFind(@Path("favoriteId") Long id);


    //DELETE
    @DELETE("/api/v1/comments/{favoriteId}")
    Call<JsonElement> favoriteDelete(@Path("favoriteId") Long id);


    //UPDATE
    @PUT("/api/v1/comments/{favoriteId}")
    Call<JsonElement> favoriteUpdate(@Path("favoriteId") Long id, @Body JsonElement jsonElement);
}
