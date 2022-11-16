package com.emregecer.udemy.springboot.controller;

import com.emregecer.udemy.springboot.entity.User;
import com.emregecer.udemy.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST API
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User user = userService.getUserById(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // build get all users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // build update user REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setId(userId);
        User updateUser = userService.updateUser(user);

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    // Build delete user REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}