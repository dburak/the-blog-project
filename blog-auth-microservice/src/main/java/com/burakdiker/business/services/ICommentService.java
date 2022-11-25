package com.burakdiker.business.services;

import com.google.gson.JsonElement;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    //SAVE
    JsonElement commentSave(JsonElement jsonElement);

    //LIST
    List<JsonElement> commentList(Long blogId);


    //FIND
    JsonElement commentFind(Long id);

    //DELETE
    void commentDelete(Long id);

    //UPDATE
    JsonElement commentUpdate(Long id,JsonElement jsonElement);
}
