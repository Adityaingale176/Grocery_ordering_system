package com.Grocery.Grocery_ordering_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShutdownController {

    @Autowired
    private ApplicationContext context;

    @PostMapping("/shutdown")
    public void shutdown() {
        SpringApplication.exit(context, () -> 0);
    }
}