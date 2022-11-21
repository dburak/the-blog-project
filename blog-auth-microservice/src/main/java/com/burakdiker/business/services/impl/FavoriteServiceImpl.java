package com.burakdiker.business.services.impl;

import com.burakdiker.business.services.IFavoriteService;
import com.burakdiker.retrofit.RetrofitCommonGenerics;
import com.burakdiker.retrofit.request.ICommentServiceRequest;
import com.burakdiker.retrofit.request.IFavoriteServiceRequest;
import com.google.gson.JsonElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Log4j2

@Service
public class FavoriteServiceImpl implements IFavoriteService {


    //injection
    private final IFavoriteServiceRequest iFavoriteServiceRequest;


    @Override
    public JsonElement favoriteSave(JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iFavoriteServiceRequest.favoriteSave(jsonElement));
    }

    @Override
    public List<JsonElement> favoriteList() {
        return RetrofitCommonGenerics.retrofitGenerics(iFavoriteServiceRequest.favoriteList());
    }

    @Override
    public JsonElement favoriteFind(Long id) {
        return RetrofitCommonGenerics.retrofitGenerics(iFavoriteServiceRequest.favoriteFind(id));
    }

    @Override
    public void favoriteDelete(Long id) {

    }

    @Override
    public JsonElement favoriteUpdate(Long id, JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iFavoriteServiceRequest.favoriteUpdate(id, jsonElement));
    }
}
