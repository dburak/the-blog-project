package com.burakdiker.api.impl;

import com.burakdiker.api.IFavoriteApi;
import com.burakdiker.business.services.IFavoriteService;
import com.burakdiker.error.ApiResult;
import com.google.gson.JsonElement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("gateway/favorite")
public class FavoriteApiImpl implements IFavoriteApi {

    //Injection
    private final IFavoriteService favoriteService;
    private static final String PATH = "gateway/favorite";


    @Override
    @PostMapping
    public ApiResult saveFavorite(JsonElement jsonElement) {
        favoriteService.favoriteSave(jsonElement);
        return new ApiResult(200, "Register Successfull", PATH);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<?>> listFavorite() {
        favoriteService.favoriteList();
        return ResponseEntity.ok(favoriteService.favoriteList());
    }

    @Override
    @GetMapping("/{favoriteId}")
    public ResponseEntity<?> findFavorite(@PathVariable Long favoriteId) {
        return ResponseEntity.ok(favoriteService.favoriteFind(favoriteId));
    }

    @Override
    @DeleteMapping("/{favoriteId}")
    public ApiResult deleteFavorite(@PathVariable Long favoriteId) {
        favoriteService.favoriteDelete(favoriteId);
        return new ApiResult(200, "Deleted", PATH);
    }

    @Override
    @PutMapping
    public ApiResult updateFavorite(Long id, JsonElement jsonElement) {
        favoriteService.favoriteUpdate(id,jsonElement);
        return new ApiResult(200, "Updated", PATH);
    }
}
