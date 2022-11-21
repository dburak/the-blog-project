package com.burakdiker.business.services;

import com.google.gson.JsonElement;

import java.util.List;

public interface IFavoriteService {
    //SAVE
    JsonElement favoriteSave(JsonElement jsonElement);

    //LIST
    List<JsonElement> favoriteList();

    //FIND
    JsonElement favoriteFind(Long id);

    //DELETE
    void favoriteDelete(Long id);

    //UPDATE
    JsonElement favoriteUpdate(Long id,JsonElement jsonElement);
}
