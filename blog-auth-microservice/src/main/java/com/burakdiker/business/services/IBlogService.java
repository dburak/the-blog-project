package com.burakdiker.business.services;

import com.google.gson.JsonElement;

import java.util.List;

public interface IBlogService {
    //SAVE
    JsonElement blogSave(JsonElement jsonElement);

    //LIST
    List<JsonElement> blogList();

    //FIND
    JsonElement blogFind(Long id);

    //DELETE
    void blogDelete(Long id);

    //UPDATE
    JsonElement blogUpdate(Long id,JsonElement jsonElement);
}
