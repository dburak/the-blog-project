package com.blog.burakdiker.business.dto;


import com.blog.burakdiker.data.entity.BlogEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BlogDto {

    private Long id;
    private Long userId;
    private String userName;
    private String blogTitle;
    private String blogContent;
    private List<FavoriteDto> blogFavorites;


    public BlogDto(BlogEntity entity, List<FavoriteDto> favorites){
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.blogTitle = entity.getBlogTitle();
        this.blogContent = entity.getBlogContent();
        this.blogFavorites = favorites;
    }


}
