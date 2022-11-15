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
    private Long id;
    private Long blogId;
    private Long userId;
}
