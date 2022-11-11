package com.blog.burakdiker.data.entity;

import com.blog.burakdiker.business.dto.BlogDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity //table mapping
@Table(name="blog")
@Data //getters setters
public class BlogEntity {

    @Id
    long id;


    @ManyToOne(fetch = FetchType.LAZY) // to get only blog entity without user
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    UserEntity user;

    String blogTitle;

    @Lob
    @Column(columnDefinition = "text")
    String blogContent;

}
