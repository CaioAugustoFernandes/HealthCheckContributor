package com.example.healthindicator.config;

import org.springframework.boot.actuate.health.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.stream.Stream;

@Configuration
public class HealthCheckConfig {

    @Bean
    public HealthContributorRegistry healthContributorRegistry(ApplicationContext applicationContext){
        Map<String, HealthContributor> beansOfType = applicationContext.getBeansOfType(HealthContributor.class);
        Stream.of(beansOfType).forEach(stringHealthContributorMap -> System.out.println(stringHealthContributorMap));
        beansOfType.remove("pingHealthContributor");
        Stream.of(beansOfType).forEach(stringHealthContributorMap -> System.out.println(stringHealthContributorMap));
        return new DefaultHealthContributorRegistry(beansOfType);
    }

}
