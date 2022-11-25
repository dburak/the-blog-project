package com.burakdiker.api.impl;

import com.burakdiker.business.services.IBlogService;
import com.burakdiker.error.ApiResult;
import com.google.gson.JsonElement;
import com.burakdiker.api.IBlogApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("gateway/blog")
public class BlogApiImpl implements IBlogApi {

    //Injection
    private final IBlogService blogService;
    private static final String PATH = "gateway/blog";

    @Override
    @PostMapping
    public ApiResult saveBlog(@RequestBody JsonElement jsonElement) {
        blogService.blogSave(jsonElement);
        return new ApiResult(200, "Blog is successfully sent", PATH);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<?>> listBlog() {
        blogService.blogList();
        return ResponseEntity.ok(blogService.blogList());
    }

    @Override
    @GetMapping("/{blogId}")
    public ResponseEntity<?> findBlog(@PathVariable Long blogId) {
        return ResponseEntity.ok(blogService.blogFind(blogId));
    }

    @Override
    @DeleteMapping("/{blogId}")
    public ApiResult deleteBlog(@PathVariable Long blogId) {
        blogService.blogDelete(blogId);
        return new ApiResult(200, "Deleted", PATH);
    }

    @Override
    @PutMapping("/{blogId}")
    public ApiResult updateBlog(@PathVariable Long id, @RequestBody JsonElement jsonElement) {
        blogService.blogUpdate(id,jsonElement);
        return new ApiResult(200, "Updated", PATH);
    }
}
