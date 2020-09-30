package com.arindam.microservice.controller;

import com.arindam.microservice.entity.User;
import com.arindam.microservice.repository.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
