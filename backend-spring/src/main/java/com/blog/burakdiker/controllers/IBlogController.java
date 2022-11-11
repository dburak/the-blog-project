package com.blog.burakdiker.controllers;

import com.blog.burakdiker.business.dto.BlogDto;
import com.blog.burakdiker.business.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IBlogController {

    //LIST
    ResponseEntity<List<BlogDto>> listBlogs(Optional<Long> userId);

    //CREATE
    ResponseEntity<?> createBlog(BlogDto blogDto);

    //FIND
    ResponseEntity<BlogDto> findBlog(Long id);

    //UPDATE
    ResponseEntity<BlogDto> updateBlog(Long id, BlogDto blogDto);

    //DELETE
    ResponseEntity <Map<String, Boolean>> deleteBlog(Long id);


}
