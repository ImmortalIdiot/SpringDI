package com.immortalidiot.SpringDI.config;

import com.immortalidiot.SpringDI.service.GreetingService;
import com.immortalidiot.SpringDI.service.impl.MorningGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GreetingConfig {

    @Bean
    @Scope("prototype")
    public GreetingService greetingService() {
        return new MorningGreetingService();
    }
}
