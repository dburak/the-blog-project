package com.blog.burakdiker.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity //table mapping
@Table(name="comment")
@Data //getters setters
public class CommentEntity {

    @Id
    long id;

    @ManyToOne(fetch = FetchType.LAZY) // to get only comment entity without user
    @JoinColumn(name = "blog_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    BlogEntity blog;

    @ManyToOne(fetch = FetchType.LAZY) // to get only comment entity without user
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    UserEntity user;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
