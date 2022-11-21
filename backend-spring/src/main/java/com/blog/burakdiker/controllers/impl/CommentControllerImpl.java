package com.blog.burakdiker.controllers.impl;

import com.blog.burakdiker.business.dto.BlogDto;
import com.blog.burakdiker.business.dto.CommentDto;
import com.blog.burakdiker.business.services.ICommentServices;
import com.blog.burakdiker.controllers.ICommentController;
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
@RequestMapping("/api/v1/comments")
@CrossOrigin
public class CommentControllerImpl implements ICommentController {


    //injection services
    private final ICommentServices services;


    // LIST
    @Override
    @GetMapping
    public ResponseEntity<List<CommentDto>> listComments(@RequestParam Optional<Long> userId,
                                                         @RequestParam Optional<Long> commentId) {
        return ResponseEntity.ok(services.listComments(userId, commentId));
    }

    // CREATE
    @Override
    @PostMapping
    public ResponseEntity<?> createComment(@Valid @RequestBody CommentDto commentDto) {
        services.createComment(commentDto);
        return ResponseEntity.ok(commentDto);
    }

    // FIND
    @Override
    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> findComment(@PathVariable Long commentId) {
        return ResponseEntity.ok(services.findComment(commentId));
    }

    // UPDATE
    @Override
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long commentId, @Valid @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(services.updateComment(commentId, commentDto));
    }

    // DELETE
    @Override
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Map<String, Boolean>> deleteComment(@PathVariable Long commentId) {
        services.deleteComment(commentId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
