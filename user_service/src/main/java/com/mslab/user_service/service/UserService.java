package com.mslab.user_service.service;

import com.mslab.user_service.model.Blog;
import com.mslab.user_service.model.User;
import com.mslab.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    private RestTemplate restTemplate;
    private final UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(String userID){

        User user = userRepository.findById(userID).orElse(null);

        if (user != null) {
            ArrayList<Blog> userBlogs = restTemplate.getForObject("http://localhost:3002/blogs?userID=" + userID, ArrayList.class);
            user.setBlogs(userBlogs);
        }
        return user;
    }

    public User createUser(User user){
        String randomID = UUID.randomUUID().toString();
        user.setUserID(randomID);
        return userRepository.save(user);
    }
}
