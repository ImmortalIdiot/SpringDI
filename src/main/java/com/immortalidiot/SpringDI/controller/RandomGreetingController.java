package com.immortalidiot.SpringDI.controller;

import com.immortalidiot.SpringDI.service.GreetingService;
import com.immortalidiot.SpringDI.service.RandomGreetingServiceSelecter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomGreetingController {

    private final RandomGreetingServiceSelecter randomGreetingServiceSelector;

    @Autowired
    public RandomGreetingController(RandomGreetingServiceSelecter randomGreetingServiceSelector) {
        this.randomGreetingServiceSelector = randomGreetingServiceSelector;
    }

    @GetMapping("/random-greeting")
    public String getRandomGreeting() {
        GreetingService randomGreetingService = randomGreetingServiceSelector.getRandomGreetingService();
        return randomGreetingService.getGreeting();
    }
}
