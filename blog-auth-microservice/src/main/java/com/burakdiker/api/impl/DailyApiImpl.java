package com.burakdiker.api.impl;

import com.burakdiker.api.IDailyApi;
import com.burakdiker.error.ApiResult;
import com.google.gson.JsonElement;
import com.burakdiker.business.services.IDailyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Lombok
@RequiredArgsConstructor

@RestController
@RequestMapping("gateway/daily")
public class DailyApiImpl implements IDailyApi {

    //Injection
    private final IDailyService dailyService;
    private static final String PATH = "gateway/daily";

    //SAVE
    //http://localhost:1111/gateway/daily  ==> POST
    @Override
    @PostMapping
    public ApiResult saveDaily(@RequestBody JsonElement jsonElement) {
        dailyService.dailySave(jsonElement);
        return new ApiResult(200, "Kayıt olundu", PATH);
    }

    //LIST
    //http://localhost:1111/gateway/daily  ==> GET
    @Override
    @GetMapping
    public ResponseEntity<List<?>> listDaily() {
        dailyService.dailyList();
        return ResponseEntity.ok(dailyService.dailyList());
    }

    //FIND
    //http://localhost:1111/gateway/daily/1
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> findDaily(@PathVariable(name="id") Long id) {
        return ResponseEntity.ok(dailyService.dailyFind(id));
    }

    //DELETE
    //http://localhost:1111/gateway/daily/1
    @Override
    @DeleteMapping("/{id}")
    public ApiResult deleteDaily(@PathVariable(name = "id") Long id) {
        dailyService.dailyDelete(id);
        return new ApiResult(200, "Deleted", PATH);
    }

    //UPDATE
    //http://localhost:1111/gateway/daily/1
    @Override
    @PutMapping("/{id}")
    public ApiResult updateDaily(@PathVariable(name="id")Long id, @RequestBody  JsonElement jsonElement) {
        dailyService.dailyUpdate(id,jsonElement);
        return new ApiResult(200, "Updated", PATH);
    }
}
