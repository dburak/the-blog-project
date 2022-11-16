package com.blog.burakdiker.data.repository;

import com.blog.burakdiker.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
