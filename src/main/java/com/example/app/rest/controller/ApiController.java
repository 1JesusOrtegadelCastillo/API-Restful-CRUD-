package com.example.app.rest.controller;

import com.example.app.rest.entity.User;
import com.example.app.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController  {
    // injecting UserService with autowired
    @Autowired
    private UserService userService;

    // Create new
    @PostMapping(value = "/save")
    public User saveUser(@RequestBody User newUser){
        String user = userService.saveUser(newUser);
        return newUser;
    }

    //Get registered users
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    //Update user
    @PutMapping(value = "/update/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User updatedUser){
        String user = userService.updateUser(id, updatedUser);
        return updatedUser;
    }

    // delete user
    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }

}
