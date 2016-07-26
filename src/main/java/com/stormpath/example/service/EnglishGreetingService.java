package com.stormpath.example.service;

import org.springframework.stereotype.Service;

@Service
public class EnglishGreetingService implements GreetingService {

    public String greet() {
        return "Hello";
    }
}
