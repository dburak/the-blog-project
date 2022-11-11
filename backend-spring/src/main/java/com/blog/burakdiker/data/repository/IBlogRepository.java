package com.blog.burakdiker.data.repository;

import com.blog.burakdiker.business.dto.BlogDto;
import com.blog.burakdiker.data.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BlogEntity, Long> {

    List<BlogEntity> findByUserId(Long userId);

}
