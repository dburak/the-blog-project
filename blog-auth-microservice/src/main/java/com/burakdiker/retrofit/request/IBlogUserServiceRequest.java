package com.burakdiker.retrofit.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface IBlogUserServiceRequest {
    @POST("/api/v1/users")
    Call<JsonElement> userSave(@Body JsonElement jsonElement);

    //LIST
    @GET("/api/v1/users")
    Call<List<JsonElement>> userList();

    //FIND
    @GET("/api/v1/users/{userId}")
    Call<JsonElement> userFind(@Path("userId") Long id);


    //DELETE
    @DELETE("/api/v1/users/{userId}")
    Call<JsonElement> userDelete(@Path("blogId") Long id);


    //UPDATE
    @PUT("/api/v1/users/{userId}")
    Call<JsonElement> userUpdate(@Path("blogId") Long id,@Body JsonElement jsonElement);
}
