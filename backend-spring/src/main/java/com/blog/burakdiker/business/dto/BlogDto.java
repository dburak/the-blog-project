package com.blog.burakdiker.business.dto;


import com.blog.burakdiker.data.entity.BlogEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm dd.MM.yyyy", timezone = "Europe/Istanbul")
    private Date createdDate;
    private List<FavoriteDto> blogFavorites;


    public BlogDto(BlogEntity entity, List<FavoriteDto> favorites){
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.blogTitle = entity.getBlogTitle();
        this.blogContent = entity.getBlogContent();
        this.createdDate = entity.getCreatedDate();
        this.blogFavorites = favorites;
    }


}
