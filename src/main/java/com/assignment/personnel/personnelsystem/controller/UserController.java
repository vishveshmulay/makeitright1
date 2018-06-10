package com.assignment.personnel.personnelsystem.controller;
 
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.personnel.personnelsystem.entity.User;
import com.assignment.personnel.personnelsystem.service.UserService;
 
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @PostMapping("/")
    public void createNewUser(@Valid @RequestBody User user) {
        userService.addUser(user);
    }
 
    @PutMapping("/")
    public void changeExistingUser(@Valid @RequestBody User user) {
        userService.modifyUser(user);
    }
 
    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable(value = "id") long userId) {
        userService.removeUser(userId);
    }
 
    @GetMapping("/{id}")
    public User viewUserById(@PathVariable(value = "id") long userId) {
        return userService.getUserById(userId);
    }
 
    @GetMapping("/")
    public List<User> viewAllUser() {
        return userService.getAllUser();
    }
 
}