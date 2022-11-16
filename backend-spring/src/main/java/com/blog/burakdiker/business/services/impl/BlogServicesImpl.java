package com.blog.burakdiker.business.services.impl;

import com.blog.burakdiker.bean.ModelMapperBean;
import com.blog.burakdiker.business.dto.BlogDto;
import com.blog.burakdiker.business.dto.UserDto;
import com.blog.burakdiker.business.services.IBlogServices;
import com.blog.burakdiker.data.entity.BlogEntity;
import com.blog.burakdiker.data.entity.UserEntity;
import com.blog.burakdiker.data.repository.IBlogRepository;
import com.blog.burakdiker.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@RequiredArgsConstructor
@Log4j2

@Service
@Transactional
public class BlogServicesImpl implements IBlogServices {

    //injection
    private final IBlogRepository repository;
    private final ModelMapperBean modelMapperBean;
    private final UserServicesImpl userServices;


    @Override
    public BlogDto entityToDto(BlogEntity blogEntity) {
        return modelMapperBean.modelMapperMethod().map(blogEntity, BlogDto.class);
    }

    @Override
    public BlogEntity dtoToEntity(BlogDto blogDto) {
        return modelMapperBean.modelMapperMethod().map(blogDto, BlogEntity.class);
    }

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        UserDto user = userServices.findUser(blogDto.getUserId());
        if(user == null)
            return null;
        BlogEntity blogEntity = dtoToEntity(blogDto);
        repository.save(blogEntity);
        return blogDto;
    }

    @Override
    public List<BlogDto> listBlogs(Optional<Long> userId) {

        List<BlogEntity> blogEntityList;
        List<BlogDto> dtoList = new ArrayList<>();
        if(userId.isPresent()) {
            blogEntityList = repository.findByUserId(userId.get());
            for (BlogEntity temp : blogEntityList) {
                BlogDto entityToDto = entityToDto(temp);
                dtoList.add(entityToDto);
            }
        }
        else {

            blogEntityList = repository.findAll();
            for (BlogEntity temp : blogEntityList) {
                BlogDto entityToDto = entityToDto(temp);
                dtoList.add(entityToDto);
            }
        }
        return dtoList;
    }

    @Override
    public BlogDto findBlog(Long blogId) {
        BlogEntity blogEntity = repository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException(blogId + " id cannot be found"));
        BlogDto entityToDto = entityToDto(blogEntity);
        return entityToDto;
    }

    @Override
    public Map<String, Boolean> deleteBlog(Long id) {
        BlogEntity blogEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id cannot be found"));
        repository.delete(blogEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public BlogDto updateBlog(Long id, BlogDto blogDto) {
        BlogEntity blogEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id cannot be found"));
        if (blogEntity != null) {
            blogEntity.setBlogTitle(blogDto.getBlogTitle());
            blogEntity.setBlogContent(blogDto.getBlogContent());
            repository.save(blogEntity);
        }
        return blogDto;
    }
}
