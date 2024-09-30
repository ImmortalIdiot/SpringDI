package com.immortalidiot.SpringDI.config;

import com.immortalidiot.SpringDI.service.GreetingService;
import com.immortalidiot.SpringDI.service.impl.AfternoonGreetingService;
import com.immortalidiot.SpringDI.service.impl.EveningGreetingService;
import com.immortalidiot.SpringDI.service.impl.MorningGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalTime;

@Configuration
public class GreetingConfig {

    @Bean
    @Scope("prototype")
    public GreetingService greetingService() {
        LocalTime nowTime = LocalTime.now();

        if (nowTime.isAfter(LocalTime.of(6, 0)) &&
                nowTime.isBefore(LocalTime.of(12, 0))) {
            return new MorningGreetingService();
        } else if (nowTime.isAfter(LocalTime.of(12, 0)) &&
                nowTime.isBefore(LocalTime.of(18, 0))) {
            return new AfternoonGreetingService();
        } else {
            return new EveningGreetingService();
        }
    }
}
