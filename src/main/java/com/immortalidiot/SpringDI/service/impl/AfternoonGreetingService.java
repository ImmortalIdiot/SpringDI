package com.immortalidiot.SpringDI.service.impl;

import com.immortalidiot.SpringDI.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class AfternoonGreetingService implements GreetingService {

    @Override
    public String getGreeting() {
        return "Good afternoon!";
    }
}
