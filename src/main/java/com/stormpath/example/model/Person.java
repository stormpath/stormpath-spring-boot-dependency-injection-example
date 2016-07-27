package com.stormpath.example.model;

import org.springframework.stereotype.Component;

@Component
public class Person implements Nameable {

    @Override
    public String getName() {
        return "Micah";
    }
}
