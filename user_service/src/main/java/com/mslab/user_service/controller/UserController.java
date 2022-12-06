package com.mslab.user_service.controller;

import com.mslab.user_service.model.User;
import com.mslab.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User craeateUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){

        return  userService.getAllUsers();
    }

    @GetMapping("/{userID}")
    public User getUser(@PathVariable String userID){
        return userService.getUser(userID);
    }
}
