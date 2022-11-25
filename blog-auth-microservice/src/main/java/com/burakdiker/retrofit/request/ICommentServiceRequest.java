package com.burakdiker.retrofit.request;

import com.google.gson.JsonElement;
import org.springframework.web.bind.annotation.RequestParam;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Optional;

public interface ICommentServiceRequest {

    @POST("/api/v1/comments")
    Call<JsonElement> commentSave(@Body JsonElement jsonElement);

    //LIST
    @GET("/api/v1/comments")
    Call<List<JsonElement>> commentList(@Query("blogId") Long blogId);


    //FIND
    @GET("/api/v1/comments/{commentId}")
    Call<JsonElement> commentFind(@Path("commentId") Long id);


    //DELETE
    @DELETE("/api/v1/comments/{commentId}")
    Call<JsonElement> commentDelete(@Path("commentId") Long id);


    //UPDATE
    @PUT("/api/v1/comments/{commentId}")
    Call<JsonElement> commentUpdate(@Path("commentId") Long id,@Body JsonElement jsonElement);
}
