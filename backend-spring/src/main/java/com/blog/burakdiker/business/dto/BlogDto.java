package com.blog.burakdiker.business.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BlogDto {

    private long id;
    private long userId;
    private String blogTitle;
    private String blogContent;
}
