package com.burakdiker.business.services.impl;


import com.burakdiker.business.services.ICommentService;
import com.burakdiker.retrofit.RetrofitCommonGenerics;
import com.burakdiker.retrofit.request.ICommentServiceRequest;
import com.google.gson.JsonElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2

@Service
public class CommentServiceImpl implements ICommentService {

    //injection
    private final ICommentServiceRequest iCommentServiceRequest;

    @Override
    public JsonElement commentSave(JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iCommentServiceRequest.commentSave(jsonElement));
    }

    @Override
    public List<JsonElement> commentList() {
        return RetrofitCommonGenerics.retrofitGenerics(iCommentServiceRequest.commentList());
    }

    @Override
    public JsonElement commentFind(Long id) {
        return RetrofitCommonGenerics.retrofitGenerics(iCommentServiceRequest.commentFind(id));
    }

    @Override
    public void commentDelete(Long id) {
        RetrofitCommonGenerics.retrofitGenerics(iCommentServiceRequest.commentDelete(id));
    }

    @Override
    public JsonElement commentUpdate(Long id, JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iCommentServiceRequest.commentUpdate(id, jsonElement));

    }
}
