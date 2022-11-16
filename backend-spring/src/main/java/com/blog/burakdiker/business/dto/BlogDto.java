package com.blog.burakdiker.business.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
