package com.blog.burakdiker.data.entity;

import com.blog.burakdiker.business.dto.BlogDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity //table mapping
@Table(name="blog")
@Data //getters setters
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    long id;

    @ManyToOne(fetch = FetchType.EAGER) // to get blog entity with user
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    UserEntity user;

    String blogTitle;

    @Lob
    @Column(columnDefinition = "text")
    String blogContent;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;

}
