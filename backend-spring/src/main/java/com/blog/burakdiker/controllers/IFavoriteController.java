package com.blog.burakdiker.controllers;


import com.blog.burakdiker.business.dto.FavoriteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IFavoriteController {

    //LIST
    ResponseEntity<List<FavoriteDto>> listFavorites(Optional<Long> userId, Optional<Long> blogId);

    //CREATE
    ResponseEntity<?> createFavorite(FavoriteDto favoriteDto);

    //FIND
    ResponseEntity<FavoriteDto> findFavorite(Long id);

    //DELETE
    ResponseEntity <Map<String, Boolean>> deleteFavorite(Long id);
}
