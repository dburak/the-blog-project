package com.blog.burakdiker.data.repository;

import com.blog.burakdiker.data.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByUserIdAndBlogId(Long userId, Long blogId);
    List<CommentEntity> findByUserId(Long userId);
    List<CommentEntity> findByBlogId(Long userId);

}
