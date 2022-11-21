package com.burakdiker.business.services;

import com.google.gson.JsonElement;

import java.util.List;

public interface ICommentService {
    //SAVE
    JsonElement commentSave(JsonElement jsonElement);

    //LIST
    List<JsonElement> commentList();

    //FIND
    JsonElement commentFind(Long id);

    //DELETE
    void commentDelete(Long id);

    //UPDATE
    JsonElement commentUpdate(Long id,JsonElement jsonElement);
}
