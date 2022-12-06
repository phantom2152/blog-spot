package com.mslab.blog_service.controller;

import com.mslab.blog_service.model.Blog;
import com.mslab.blog_service.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class UserController {
    private final BlogService blogService;

    public UserController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> getAllBlogs(@RequestParam(required = false) String userID) {

        String user = (userID==null) ? "" : userID;
        return blogService.getAllBlogs(user);
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog){
        return blogService.createBlog(blog);
    }

    @GetMapping("/{blogID}")
    public Blog getBlog(@PathVariable String blogID){
        return blogService.getBlog(blogID);
    }
}
