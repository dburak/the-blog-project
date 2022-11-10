package com.blog.burakdiker.data.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //table mapping
@Table(name="favorite")
@Data //getters setters

public class FavoriteEntity {

    @Id
    long id;
    long blogId;
    long userId;

}
