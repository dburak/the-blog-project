package com.burakdiker.business.services;

import com.google.gson.JsonElement;

import java.util.List;

public interface IDailyService {

    //SAVE
    JsonElement dailySave(JsonElement jsonElement);

    //LIST
    List<JsonElement> dailyList();

    //FIND
    JsonElement dailyFind(Long id);

    //DELETE
    void dailyDelete(Long id);

    //UPDATE
    JsonElement dailyUpdate(Long id,JsonElement jsonElement);
}
