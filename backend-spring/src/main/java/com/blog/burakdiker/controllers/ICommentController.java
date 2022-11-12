package com.blog.burakdiker.controllers;


import com.blog.burakdiker.business.dto.CommentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICommentController {
    //LIST
    ResponseEntity<List<CommentDto>> listComments(Optional<Long> userId, Optional<Long> blogId);

    //CREATE
    ResponseEntity<?> createComment(CommentDto commentDto);

    //FIND
    ResponseEntity<CommentDto> findComment(Long id);

    //UPDATE
    ResponseEntity<CommentDto> updateComment(Long id, CommentDto commentDto);

    //DELETE
    ResponseEntity <Map<String, Boolean>> deleteComment(Long id);

}
