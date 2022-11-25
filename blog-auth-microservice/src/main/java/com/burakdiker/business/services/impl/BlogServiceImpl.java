package com.burakdiker.business.services.impl;

import com.burakdiker.business.services.IBlogService;
import com.burakdiker.retrofit.RetrofitCommonGenerics;
import com.burakdiker.retrofit.request.IBlogServiceRequest;
import com.google.gson.JsonElement;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2

@Service
public class BlogServiceImpl implements IBlogService {

    //injection
    private final IBlogServiceRequest iBlogServiceRequest;

    @Override
    public JsonElement blogSave(JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iBlogServiceRequest.blogSave(jsonElement));
    }

    @Override
    public List<JsonElement> blogList() {
        return RetrofitCommonGenerics.retrofitGenerics(iBlogServiceRequest.blogList());
    }

    @Override
    public JsonElement blogFind(Long id) {
        return RetrofitCommonGenerics.retrofitGenerics(iBlogServiceRequest.blogFind(id));
    }

    @Override
    public void blogDelete(Long id) {
        RetrofitCommonGenerics.retrofitGenerics(iBlogServiceRequest.blogDelete(id));
    }

    @Override
    public JsonElement blogUpdate(Long id, JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iBlogServiceRequest.blogUpdate(id,jsonElement));
    }
}
