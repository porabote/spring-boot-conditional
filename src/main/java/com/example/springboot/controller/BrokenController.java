package com.example.springboot.controller;

import com.example.springboot.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/error")
public class BrokenController {

    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") long id) {
        try {
            throw new IllegalArgumentException("IllegalArgumentException");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ResponseStatusException", e);
        }
    }

    @PostMapping("/error")
    public String error() {
        System.out.println("Some logic");
        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "ResponseStatusException");
    }

    @GetMapping("/iae")
    public Person throwException() {
        throw new IllegalArgumentException("IllegalArgumentException");
    }

}
