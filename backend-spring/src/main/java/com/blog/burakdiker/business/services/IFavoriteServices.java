package com.blog.burakdiker.business.services;


import com.blog.burakdiker.business.dto.FavoriteDto;
import com.blog.burakdiker.data.entity.FavoriteEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IFavoriteServices {
    FavoriteDto entityToDto(FavoriteEntity favoriteEntity);

    FavoriteEntity dtoToEntity(FavoriteDto favoriteDto);

    //CREATE
    FavoriteDto createFavorite(FavoriteDto favoriteDto);

    //LIST
    List<FavoriteDto> listFavorites(Optional<Long> userId, Optional<Long> blogId);

    //FIND
    FavoriteDto findFavorite(Long favoriteId);

    //DELETE
    Map<String,Boolean> deleteFavorite(Long favoriteId);

}
