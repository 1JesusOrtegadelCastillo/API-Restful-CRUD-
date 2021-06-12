package com.example.app.rest.service;

import com.example.app.rest.entity.User;
import com.example.app.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Validated
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String getPage(){
        return "welcome";
    }

    // Get users
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        // using JPA to return users
        return userRepository.findAll();
    }

    //Create user
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        userRepository.save(user);
        return "new user saved.";
    }

    //Update user
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepository.save(updatedUser);
        return "User updated ...";
    }

    //Delete user
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "User with the id: ("+id+") deleted.";
    }

}