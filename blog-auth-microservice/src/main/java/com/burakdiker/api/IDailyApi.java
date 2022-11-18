package com.burakdiker.api;
import com.burakdiker.error.ApiResult;
import com.google.gson.JsonElement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDailyApi {
    // REST             REQUEST
    // ----------       -------
    // @GetMapping      @GET
    // @PostMapping     @POST
    // @DeleteMapping   @DELETE
    // @PutMapping      @PUT

    // @PathVariable    @Path
    // @RequestBody     @Body

    // ResponseEntity   Call
    // DailyDto         JsonElement


    //SAVE
    ApiResult saveDaily(JsonElement jsonElement);

    //LIST
    ResponseEntity<List<?>> listDaily();

    //FIND
    ResponseEntity<?> findDaily(Long id);


    //DELETE
    ApiResult deleteDaily(Long id);

    //UPDATE
    ApiResult updateDaily(Long id,JsonElement jsonElement);
}
