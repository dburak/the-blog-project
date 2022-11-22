package com.burakdiker.business.services.impl;

import com.burakdiker.business.services.IBlogUserService;
import com.burakdiker.retrofit.RetrofitCommonGenerics;
import com.burakdiker.retrofit.request.IBlogServiceRequest;
import com.burakdiker.retrofit.request.IBlogUserServiceRequest;
import com.google.gson.JsonElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.util.List;


@RequiredArgsConstructor
@Log4j2

@Service
public class BlogUserServiceImpl implements IBlogUserService {

    //injection
    private final IBlogUserServiceRequest iBlogUserServiceRequest;

    @Override
    public JsonElement userSave(JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iBlogUserServiceRequest.userSave(jsonElement));
    }

    @Override
    public List<JsonElement> userList() {
        return RetrofitCommonGenerics.retrofitGenerics(iBlogUserServiceRequest.userList());
    }

    @Override
    public JsonElement userFind(Long id) {
        return RetrofitCommonGenerics.retrofitGenerics(iBlogUserServiceRequest.userFind(id));
    }

    @Override
    public void userDelete(Long id) {
        RetrofitCommonGenerics.retrofitGenerics(iBlogUserServiceRequest.userDelete(id));
    }

    @Override
    public JsonElement userUpdate(Long id, JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iBlogUserServiceRequest.userUpdate(id,jsonElement));
    }
}
