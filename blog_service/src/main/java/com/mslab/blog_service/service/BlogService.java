package com.mslab.blog_service.service;

import com.mslab.blog_service.model.Blog;
import com.mslab.blog_service.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog createBlog(Blog blog){
        String randomID = UUID.randomUUID().toString();
        blog.setBlogID(randomID);
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs(String userID){
        if(userID.equals(""))
            return blogRepository.findAll();

        return blogRepository.findByUserID(userID);
    }

    public Blog getBlog(String blogID){
        return blogRepository.findById(blogID).orElse(null);
    }
}
