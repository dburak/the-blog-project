package com.blog.burakdiker.controllers.impl;

import com.blog.burakdiker.business.dto.BlogDto;
import com.blog.burakdiker.business.dto.UserDto;
import com.blog.burakdiker.business.services.IBlogServices;
import com.blog.burakdiker.controllers.IBlogController;
import org.springframework.http.ResponseEntity;

import java.util.*;

import com.blog.burakdiker.business.dto.UserDto;
import com.blog.burakdiker.business.services.IUserServices;
import com.blog.burakdiker.controllers.IUserController;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor


@RestController
@RequestMapping("/api/v1/blogs")
@CrossOrigin
public class BlogControllerImpl implements IBlogController {

    //injection services
    private final IBlogServices services;

    // LIST
    @Override
    @GetMapping
    public ResponseEntity<List<BlogDto>> listBlogs(@RequestParam Optional<Long> userId) {
            return ResponseEntity.ok(services.listBlogs(userId));
    }

    // CREATE
    @Override
    @PostMapping
    public ResponseEntity<?> createBlog(@Valid @RequestBody BlogDto blogDto) {
        services.createBlog(blogDto);
        return ResponseEntity.ok(blogDto);
    }

    // FIND
    @Override
    @GetMapping("/{blogId}")
    public ResponseEntity<BlogDto> findBlog(@PathVariable Long blogId) {
        return ResponseEntity.ok(services.findBlog(blogId));
    }

    // UPDATE
    @Override
    @PutMapping("/{blogId}")
    public ResponseEntity<BlogDto> updateBlog(@PathVariable Long blogId, @Valid @RequestBody BlogDto blogDto) {
        services.updateBlog(blogId, blogDto);
        return ResponseEntity.ok(blogDto);
    }

    // DELETE
    @Override
    @DeleteMapping("/{blogId}")
    public ResponseEntity<Map<String, Boolean>> deleteBlog(@PathVariable Long blogId) {
        services.deleteBlog(blogId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
