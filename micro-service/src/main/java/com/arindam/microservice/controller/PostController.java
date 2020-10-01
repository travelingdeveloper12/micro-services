package com.arindam.microservice.controller;

import com.arindam.microservice.entity.Post;
import com.arindam.microservice.service.PostDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/microservice/post")
public class PostController {

    @Autowired
    PostDaoService postDaoService;

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        Post p = postDaoService.createPost(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
