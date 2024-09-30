package com.immortalidiot.SpringDI.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RandomGreetingServiceSelecter {

    private final List<GreetingService> greetingServices;
    private final Random random;

    public RandomGreetingServiceSelecter(List<GreetingService> greetingServices) {
        this.greetingServices = greetingServices;
        this.random = new Random();
    }

    public GreetingService getRandomGreetingService() {
        int randomIndex = random.nextInt(greetingServices.size());
        return greetingServices.get(randomIndex);
    }
}
