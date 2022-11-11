package com.blog.burakdiker.business.services;

import com.blog.burakdiker.business.dto.BlogDto;
import com.blog.burakdiker.data.entity.BlogEntity;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IBlogServices {
    BlogDto entityToDto(BlogEntity registerEntity);

    BlogEntity dtoToEntity(BlogDto registerDto);

    //CREATE
    BlogDto createBlog(BlogDto registerDto);

    //LIST
    List<BlogDto> listBlogs(Optional<Long> userId);

    //FIND
    BlogDto findBlog(Long id);

    //DELETE
    Map<String,Boolean> deleteBlog(Long id);

    //UPDATE
    BlogDto updateBlog(Long id, BlogDto registerDto);
}
