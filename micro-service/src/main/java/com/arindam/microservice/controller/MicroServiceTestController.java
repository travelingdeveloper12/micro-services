package com.arindam.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/microservice")
public class MicroServiceTestController {

    @GetMapping(path = "/test/get")
    public String testController() {
        return "This is a test method";
    }

}
