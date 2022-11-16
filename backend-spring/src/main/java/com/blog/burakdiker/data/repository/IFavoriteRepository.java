package com.blog.burakdiker.data.repository;


import com.blog.burakdiker.data.entity.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavoriteRepository extends JpaRepository<FavoriteEntity, Long> {

    List<FavoriteEntity> findByUserIdAndBlogId(Long userId, Long blogId);
    List<FavoriteEntity> findByUserId(Long userId);
    List<FavoriteEntity> findByBlogId(Long userId);

}
