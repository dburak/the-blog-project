package com.blog.burakdiker.business.services.impl;

import com.blog.burakdiker.bean.ModelMapperBean;
import com.blog.burakdiker.business.dto.BlogDto;
import com.blog.burakdiker.business.dto.CommentDto;
import com.blog.burakdiker.business.dto.UserDto;
import com.blog.burakdiker.business.services.IBlogServices;
import com.blog.burakdiker.business.services.ICommentServices;
import com.blog.burakdiker.business.services.IUserServices;
import com.blog.burakdiker.data.entity.BlogEntity;
import com.blog.burakdiker.data.entity.CommentEntity;
import com.blog.burakdiker.data.repository.ICommentRepository;
import com.blog.burakdiker.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import javax.transaction.Transactional;
import java.util.*;


@RequiredArgsConstructor
@Log4j2

@Service
@Transactional
public class CommentServicesImpl implements ICommentServices {

    //injection
    private final ICommentRepository repository;
    private final ModelMapperBean modelMapperBean;
    private final IUserServices userServices;
    private final IBlogServices blogServices;

    @Override
    public CommentDto entityToDto(CommentEntity commentEntity) {
        return modelMapperBean.modelMapperMethod().map(commentEntity, CommentDto.class);
    }

    @Override
    public CommentEntity dtoToEntity(CommentDto commentDto) {
        return modelMapperBean.modelMapperMethod().map(commentDto, CommentEntity.class);
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        UserDto user = userServices.findUser(commentDto.getUserId());
        BlogDto blog = blogServices.findBlog(commentDto.getBlogId());
        if(user == null && blog == null )
            return null;
        CommentEntity commentEntityEntity = dtoToEntity(commentDto);
        repository.save(commentEntityEntity);
        return commentDto;
    }

    @Override
    public List<CommentDto> listComments(Optional<Long> userId, Optional<Long> blogId) {
        List<CommentEntity> commentEntityList;
        List<CommentDto> dtoList = new ArrayList<>();
        if(userId.isPresent() && blogId.isPresent()) {
            commentEntityList = repository.findByUserIdAndBlogId(userId.get(), blogId.get());
            for (CommentEntity temp : commentEntityList) {
                CommentDto entityToDto = entityToDto(temp);
                dtoList.add(entityToDto);
            }
        } else if(userId.isPresent()) {
            commentEntityList = repository.findByUserId(userId.get());
            for (CommentEntity temp : commentEntityList) {
                CommentDto entityToDto = entityToDto(temp);
                dtoList.add(entityToDto);
            }
        }
        else if(blogId.isPresent()) {
            commentEntityList = repository.findByBlogId(blogId.get());
            for (CommentEntity temp : commentEntityList) {
                CommentDto entityToDto = entityToDto(temp);
                dtoList.add(entityToDto);
            }
        }
        else {

            commentEntityList = repository.findAll();
            for (CommentEntity temp : commentEntityList) {
                CommentDto entityToDto = entityToDto(temp);
                dtoList.add(entityToDto);
            }
        }
        return dtoList;
    }

    @Override
    public CommentDto findComment(Long commentId) {
        CommentEntity commentEntity = repository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException(commentId + " id cannot be found"));
        CommentDto entityToDto = entityToDto(commentEntity);
        return entityToDto;
    }

    @Override
    public Map<String, Boolean> deleteComment(Long id) {
        CommentEntity commentEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id cannot be found"));
        repository.delete(commentEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public CommentDto updateComment(Long id, CommentDto commentDto) {
        CommentEntity commentEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id cannot be found"));
        if (commentEntity != null) {
            commentEntity.setText(commentDto.getText());
            repository.save(commentEntity);
        }
        return commentDto;
    }
}
