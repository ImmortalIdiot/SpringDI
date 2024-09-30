package com.immortalidiot.SpringDI.controller;

import com.immortalidiot.SpringDI.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TimeBasedGreetingController {

    private final GreetingService greetingService;

    @Autowired
    public TimeBasedGreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/time-based-greeting")
    public String getTimeBasedGreeting() {
        return greetingService.getGreeting();
    }
}
