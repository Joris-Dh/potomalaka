package com.joris.potomalaka.controller;

import com.joris.potomalaka.model.User;
import com.joris.potomalaka.repo.userRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private userRepo userRepo;

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Hello there "+ request.getSession().getId();
    }

    //GET REQUESTS
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    //POST REQUESTS
    @PostMapping("/save-user")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "\nUser saved...";
    }

    //PUT REQUESTS
    @PutMapping("/update/user/{Id}")
    public String updateUser(@PathVariable long Id, @RequestBody User user) {
        User updateUser = userRepo.findById(Id).orElseThrow(() -> new RuntimeException("User not found with ID: " + Id));
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        updateUser.setRole(user.getRole());
        userRepo.save(updateUser);
        return "Updated user...";
    }

    //DELETE REQUESTS
    @DeleteMapping("/delete/user/{Id}")
    public String deleteUser(@PathVariable long Id) {
        User deleteUser = userRepo.findById(Id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with Id " + Id;
    }
}
