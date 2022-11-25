package com.burakdiker.api.impl;


import com.burakdiker.api.ICommentApi;
import com.burakdiker.business.services.ICommentService;
import com.burakdiker.error.ApiResult;
import com.google.gson.JsonElement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@RestController
@RequestMapping("gateway/comment")
public class CommentApiImpl implements ICommentApi {


    //Injection
    private final ICommentService commentService;
    private static final String PATH = "gateway/comment";



    @Override
    @PostMapping
    public ApiResult saveComment(@RequestBody JsonElement jsonElement) {
        commentService.commentSave(jsonElement);
        return new ApiResult(200, "Register Successfull", PATH);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<?>> listComment(@RequestParam Long blogId) {

        return ResponseEntity.ok(commentService.commentList(blogId));
    }


    @Override
    @GetMapping("/{commentId}")
    public ResponseEntity<?> findComment(@PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.commentFind(commentId));
    }

    @Override
    @DeleteMapping("/{commentId}")
    public ApiResult deleteComment(@PathVariable Long commentId) {
        commentService.commentDelete(commentId);
        return new ApiResult(200, "Deleted", PATH);
    }

    @Override
    @PutMapping("/{commentId}")
    public ApiResult updateComment(@PathVariable Long id, @RequestBody JsonElement jsonElement) {
        commentService.commentUpdate(id,jsonElement);
        return new ApiResult(200, "Updated", PATH);
    }
}
