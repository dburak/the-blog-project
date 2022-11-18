package com.burakdiker.data.repository;

import com.burakdiker.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {

   Optional<UserEntity> findByUsername(String username);
}

