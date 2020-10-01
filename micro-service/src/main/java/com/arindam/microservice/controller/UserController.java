package com.arindam.microservice.controller;

import com.arindam.microservice.entity.User;
import com.arindam.microservice.exception.custom.UserNotFoundException;
import com.arindam.microservice.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/microservice/user")
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path = "/get/all")
    public List<User> getAllUsers() {
        return userDaoService.getAllUsers();
    }

    @GetMapping(path = "/get/{id}")
    public User getUserById(@PathVariable int id) {
        User u = userDaoService.getUserById(id);
        if (u == null) {
            throw new UserNotFoundException("User Id :" + id);
        }
        return u;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User u = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
