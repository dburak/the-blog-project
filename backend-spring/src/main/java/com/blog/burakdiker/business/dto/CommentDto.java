package com.blog.burakdiker.business.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentDto {

    private Long id;
    private Long blogId;
    private Long userId;
    private String userName;
    private String text;
    private Date createdDate;
}
