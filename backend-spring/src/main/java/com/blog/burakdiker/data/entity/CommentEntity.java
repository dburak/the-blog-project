package com.blog.burakdiker.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity //table mapping
@Table(name="comment")
@Data //getters setters
public class CommentEntity {

    @Id
    long id;
    String postId;
    String userId;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
