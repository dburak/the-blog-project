package com.burakdiker.business.services;

import com.google.gson.JsonElement;

import java.util.List;

public interface IBlogUserService {
    //SAVE
    JsonElement userSave(JsonElement jsonElement);

    //LIST
    List<JsonElement> userList();

    //FIND
    JsonElement userFind(Long id);

    //DELETE
    void userDelete(Long id);

    //UPDATE
    JsonElement userUpdate(Long id,JsonElement jsonElement);
}
