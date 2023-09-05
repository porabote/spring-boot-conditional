package com.example.springboot.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties("netology.profile")
public class HelloController {

    private String from;

    public void setFrom(String from) {
        this.from = from;
    }

    @GetMapping("/")
    private String hello() {
        return String.format("Hello %s!", from);
    }

}
