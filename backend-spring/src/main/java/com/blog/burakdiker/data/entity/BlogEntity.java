package com.blog.burakdiker.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity //table mapping
@Table(name="blog")
@Data //getters setters
public class BlogEntity {

    @Id
    Long id;
    long userId;
    String header;
    @Lob
    @Column(columnDefinition = "content")
    String content;


}
