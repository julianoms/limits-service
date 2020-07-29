package com.udemy.microservice.limitsservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @GetMapping("/fault-tolerance-ex")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfig")
    public LimitsConfiguration retrieveConfigs() {
        throw new RuntimeException("Not Available");
    }

    public LimitsConfiguration fallbackRetrieveConfig(){
        return LimitsConfiguration.builder()
                .maximum(10)
                .minimum(1)
                .build();
    }
}
