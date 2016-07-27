package com.stormpath.example.model;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Nameable {

    @Override
    public String getName() {
        return "Fluffy";
    }
}
