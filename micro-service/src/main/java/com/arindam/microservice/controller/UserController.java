package com.arindam.microservice.controller;

import com.arindam.microservice.entity.User;
import com.arindam.microservice.exception.custom.UserNotFoundException;
import com.arindam.microservice.service.UserDaoService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
//        List<User> user = new ArrayList<>();
//        user.add(u);
//        Link link = linkTo(methodOn(this.getClass()).getAllUsers()).withSelfRel();
//        CollectionModel<User> collectionResult = new CollectionModel<>(user, link);
//        return collectionResult;
        return u;
    }

    @GetMapping(path = "/get/filtered/{id}")
    public MappingJacksonValue getFilteredUserContent(@PathVariable int id) {
        User u = userDaoService.getUserById(id);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept(String.valueOf(u.getId()), u.getName());
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserFilterProvider", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(u);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User u = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
