package com.backendcodingexercises.quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    public String greet(String name, String suffix) {
        if (suffix == null || suffix.isEmpty()) {
            suffix = "";
        }
        return "Hello " + name + suffix + "!";
    }
}

