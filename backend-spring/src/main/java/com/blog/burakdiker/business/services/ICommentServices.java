package com.blog.burakdiker.business.services;

import com.blog.burakdiker.business.dto.CommentDto;
import com.blog.burakdiker.data.entity.CommentEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICommentServices {
    CommentDto entityToDto(CommentEntity commentEntity);

    CommentEntity dtoToEntity(CommentDto commentDto);

    //CREATE
    CommentDto createComment(CommentDto commentDto);

    //LIST
    List<CommentDto> listComments(Optional<Long> userId, Optional<Long> blogId);

    //FIND
    CommentDto findComment(Long id);

    //DELETE
    Map<String,Boolean> deleteComment(Long id);

    //UPDATE
    CommentDto updateComment(Long id, CommentDto commentDto);
}
