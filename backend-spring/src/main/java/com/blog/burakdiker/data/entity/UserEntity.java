package com.blog.burakdiker.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity //table mapping
@Table(name="user")
@Data //getters setters
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    long id;
    String userName;
    String password;


}
