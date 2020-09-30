package com.arindam.microservice.controller;

import com.arindam.microservice.entity.MicroServiceTestBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/microservice")
public class MicroServiceTestController {

    @GetMapping(path = "/test/get")
    public String testController() {
        return "This is a test method";
    }

    @GetMapping(path = "/test/bean/get")
    public MicroServiceTestBean microServiceTestBean() {
        return new MicroServiceTestBean("This is a MicroService Test Bean Message");
    }

    @GetMapping(path = "/test/path-variable/{username}")
    public MicroServiceTestBean microServiceTestBeanForPathVariable(@PathVariable String username) {
        return new MicroServiceTestBean(String.format("Welcome, %s", username));
    }
}
