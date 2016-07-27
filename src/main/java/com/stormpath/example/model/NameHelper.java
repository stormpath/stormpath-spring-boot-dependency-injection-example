package com.stormpath.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class NameHelper {

    private Nameable person;
    private Nameable dog;

    private Nameable[] nameables;

    public String getName(String type) {
        switch (type) {
            case "person":
                return person.getName();
            case "dog":
                return dog.getName();
            default:
                return "UNKNOWN";
        }
    }

    public String[] getAllNames() {
        return Arrays.stream(nameables).map((Nameable::getName)).toArray(String[]::new);
    }

    @Autowired
    @Qualifier("person")
    public void setPerson(Nameable person) {
        this.person = person;
    }

    @Autowired
    @Qualifier("dog")
    public void setDog(Nameable dog) {
        this.dog = dog;
    }

    @Autowired
    public void setNameables(Nameable[] nameables) {
        this.nameables = nameables;
    }
}
