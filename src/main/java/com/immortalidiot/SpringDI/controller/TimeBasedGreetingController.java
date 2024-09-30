package com.immortalidiot.SpringDI.controller;

import com.immortalidiot.SpringDI.service.impl.AfternoonGreetingService;
import com.immortalidiot.SpringDI.service.impl.EveningGreetingService;
import com.immortalidiot.SpringDI.service.impl.MorningGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class TimeBasedGreetingController {

    private final AfternoonGreetingService afternoonGreetingService;
    private final EveningGreetingService eveningGreetingService;
    private final MorningGreetingService morningGreetingService;

    @Autowired
    public TimeBasedGreetingController(AfternoonGreetingService afternoonGreetingService,
                                       EveningGreetingService eveningGreetingService,
                                       MorningGreetingService morningGreetingService
    ) {
        this.afternoonGreetingService = afternoonGreetingService;
        this.eveningGreetingService = eveningGreetingService;
        this.morningGreetingService = morningGreetingService;
    }

    @GetMapping("/time-based-greeting")
    public String getTimeBasedGreeting() {
        LocalTime nowTime = LocalTime.now();

        if (nowTime.isAfter(LocalTime.of(6, 0)) && nowTime.isBefore(LocalTime.of(12, 0))) {
            return morningGreetingService.getGreeting();
        } else if (nowTime.isAfter(LocalTime.of(12, 0)) && nowTime.isBefore(LocalTime.of(18, 0))) {
            return afternoonGreetingService.getGreeting();
        } else {
            return eveningGreetingService.getGreeting();
        }
    }
}
