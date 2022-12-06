package com.mslab.blog_service.repository;

import com.mslab.blog_service.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,String> {
        List<Blog> findByUserID(String userID);
}
