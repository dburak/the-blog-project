package com.blog.burakdiker.business.services.impl;

import com.blog.burakdiker.bean.ModelMapperBean;
import com.blog.burakdiker.business.dto.BlogDto;
import com.blog.burakdiker.business.dto.CommentDto;
import com.blog.burakdiker.business.dto.FavoriteDto;
import com.blog.burakdiker.business.dto.UserDto;
import com.blog.burakdiker.business.services.IBlogServices;
import com.blog.burakdiker.business.services.IFavoriteServices;
import com.blog.burakdiker.business.services.IUserServices;
import com.blog.burakdiker.data.entity.CommentEntity;
import com.blog.burakdiker.data.entity.FavoriteEntity;
import com.blog.burakdiker.data.repository.IFavoriteRepository;
import com.blog.burakdiker.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@RequiredArgsConstructor
@Log4j2

@Service
@Transactional
public class FavoriteServicesImpl implements IFavoriteServices {

    //injection
    private final IFavoriteRepository repository;
    private final ModelMapperBean modelMapperBean;
    private final IUserServices userServices;
    private final IBlogServices blogServices;


    @Override
    public FavoriteDto entityToDto(FavoriteEntity favoriteEntity) {
        return modelMapperBean.modelMapperMethod().map(favoriteEntity, FavoriteDto.class);
    }

    @Override
    public FavoriteEntity dtoToEntity(FavoriteDto favoriteDto) {
        return modelMapperBean.modelMapperMethod().map(favoriteDto, FavoriteEntity.class);
    }

    @Override
    public FavoriteDto createFavorite(FavoriteDto favoriteDto) {
        UserDto user = userServices.findUser(favoriteDto.getUserId());
        BlogDto blog = blogServices.findBlog(favoriteDto.getBlogId());
        if(user == null && blog == null )
            return null;
        FavoriteEntity favoriteEntity = dtoToEntity(favoriteDto);
        repository.save(favoriteEntity);
        return favoriteDto;
    }

    @Override
    public List<FavoriteDto> listFavorites(Optional<Long> userId, Optional<Long> blogId) {
        List<FavoriteEntity> favoriteEntityList;
        List<FavoriteDto> dtoList = new ArrayList<>();
        if(userId.isPresent() && blogId.isPresent()) {
            favoriteEntityList = repository.findByUserIdAndBlogId(userId.get(), blogId.get());
            for (FavoriteEntity temp : favoriteEntityList) {
                FavoriteDto entityToDto = entityToDto(temp);
                dtoList.add(entityToDto);
            }
        } else if(userId.isPresent()) {
            favoriteEntityList = repository.findByUserId(userId.get());
            for (FavoriteEntity temp : favoriteEntityList) {
                FavoriteDto entityToDto = entityToDto(temp);
                dtoList.add(entityToDto);
            }
        }
        else if(blogId.isPresent()) {
            favoriteEntityList = repository.findByBlogId(blogId.get());
            for (FavoriteEntity temp : favoriteEntityList) {
                FavoriteDto entityToDto = entityToDto(temp);
                dtoList.add(entityToDto);
            }
        }
        else {

            favoriteEntityList = repository.findAll();
            for (FavoriteEntity temp : favoriteEntityList) {
                FavoriteDto entityToDto = entityToDto(temp);
                dtoList.add(entityToDto);
            }
        }
        return dtoList;
    }

    @Override
    public FavoriteDto findFavorite(Long favoriteId) {
        FavoriteEntity favoriteEntity = repository.findById(favoriteId).orElseThrow(() -> new ResourceNotFoundException(favoriteId + " id cannot be found"));
        FavoriteDto entityToDto = entityToDto(favoriteEntity);
        return entityToDto;
    }

    @Override
    public Map<String, Boolean> deleteFavorite(Long favoriteId) {
        FavoriteEntity favoriteEntity = repository.findById(favoriteId).orElseThrow(() -> new ResourceNotFoundException(favoriteId + " id cannot be found"));
        repository.delete(favoriteEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
