package com.stormpath.example.config;

import com.stormpath.example.service.EnglishGreetingService;
import com.stormpath.example.service.FrenchGreetingService;
import com.stormpath.example.service.GreetingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    @ConditionalOnProperty(name = "language.name", havingValue = "english", matchIfMissing = true)
    public GreetingService englishGreetingService() {
        return new EnglishGreetingService();
    }

    @Bean
    @ConditionalOnProperty(name = "language.name", havingValue = "french")
    public GreetingService frenchGreetingService() {
        return new FrenchGreetingService();
    }
}
