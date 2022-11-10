package com.blog.burakdiker.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //table mapping
@Table(name="user")
@Data //getters setters
public class UserEntity {

    @Id
    long id;
    String userName;
    String password;


}
