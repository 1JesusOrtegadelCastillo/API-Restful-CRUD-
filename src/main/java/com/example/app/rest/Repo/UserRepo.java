package com.example.app.rest.Repo;

import com.example.app.rest.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
