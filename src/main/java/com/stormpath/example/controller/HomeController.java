package com.stormpath.example.controller;

import com.stormpath.example.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping("/")
    public String home() {
        return greetingService.greet();
    }
}
