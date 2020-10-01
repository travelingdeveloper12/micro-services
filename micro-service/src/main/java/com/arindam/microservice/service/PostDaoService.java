package com.arindam.microservice.service;

import com.arindam.microservice.entity.Post;
import org.springframework.stereotype.Service;

@Service
public class PostDaoService {

    public Post createPost(Post post) {
        return new Post();
    }

}
