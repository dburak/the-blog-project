package com.blog.burakdiker.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FavoriteDto {
    private long id;
    private long blogId;
    private long userId;
}