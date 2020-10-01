package com.arindam.microservice.repository;

import com.arindam.microservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoService {
    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    public User save(User user) {
        return new User();
    }

    public User getUserById(int id) {
        return new User();
    }

}
