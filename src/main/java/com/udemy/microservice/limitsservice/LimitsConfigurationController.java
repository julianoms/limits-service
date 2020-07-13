package com.udemy.microservice.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    @Autowired
    private Configuration configuration;

    @GetMapping("/v1/limits")
    public LimitsConfiguration retrieveLimitsFromConfigs() {
        return LimitsConfiguration.builder()
                .maximum(configuration.getMaximum())
                .minimum(configuration.getMinimum())
                .build();
    }
}
