package com.burakdiker.retrofit.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface IBlogServiceRequest {
    @POST("/api/v1/blogs")
    Call<JsonElement> blogSave( @Body JsonElement jsonElement);

    //LIST
    @GET("/api/v1/blogs")
    Call<List<JsonElement>> blogList();

    //FIND
    @GET("/api/v1/blogs/{blogId}")
    Call<JsonElement> blogFind(@Path("blogId") Long id);


    //DELETE
    @DELETE("/api/v1/blogs/{blogId}")
    Call<JsonElement> blogDelete(@Path("blogId") Long id);


    //UPDATE
    @PUT("/api/v1/blogs/{blogId}")
    Call<JsonElement> blogUpdate(@Path("blogId") Long id,@Body JsonElement jsonElement);
}
