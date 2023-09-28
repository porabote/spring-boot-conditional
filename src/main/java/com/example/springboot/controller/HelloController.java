package com.example.springboot.controller;

import com.example.springboot.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("myAppTest")
    private String from;

    @PostMapping("/hello")
    private String hello(@RequestBody @Validated Person guest) {
        return String.format("Hello %s to name %s age %d!",
                from, guest.getName(), guest.getAge());
    }

}
