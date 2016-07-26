package com.stormpath.example.service;

public class FrenchGreetingService  implements GreetingService {

    @Override
    public String greet() {
        return "Bonjour Monde!";
    }
}
