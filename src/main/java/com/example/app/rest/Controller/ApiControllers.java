package com.example.app.rest.Controller;

import com.example.app.rest.Model.User;
import com.example.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    // injecting repository with autowired
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "welcome";
    }

    // Get users
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        // using JPA to return users
        return userRepo.findAll();
    }

    //Create user
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "new user saved.";
    }

    //Update user
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "User updated ...";
    }

    //Delete user
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "User with the id: ("+id+") deleted.";
    }

}
