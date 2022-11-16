package com.blog.burakdiker.controllers.impl;

import com.blog.burakdiker.business.dto.FavoriteDto;
import com.blog.burakdiker.business.services.IFavoriteServices;
import com.blog.burakdiker.controllers.IFavoriteController;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/favorites")
@CrossOrigin
public class FavoriteControllerImpl implements IFavoriteController {

    //injection services
    private final IFavoriteServices services;


    @Override
    @GetMapping
    public ResponseEntity<List<FavoriteDto>> listFavorites(@RequestParam Optional<Long> userId,
                                                           @RequestParam Optional<Long> blogId) {
        return ResponseEntity.ok(services.listFavorites(userId, blogId));
    }

    @Override
    @PostMapping
    public ResponseEntity<?> createFavorite(@Valid @RequestBody FavoriteDto favoriteDto) {
        services.createFavorite(favoriteDto);
        return ResponseEntity.ok(favoriteDto);
    }

    @Override
    @GetMapping("/{favoriteId}")
    public ResponseEntity<FavoriteDto> findFavorite(@PathVariable Long favoriteId) {
        return ResponseEntity.ok(services.findFavorite(favoriteId));
    }

    @Override
    @DeleteMapping("/{favoriteId}")
    public ResponseEntity<Map<String, Boolean>> deleteFavorite(@PathVariable Long favoriteId) {
        services.deleteFavorite(favoriteId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
