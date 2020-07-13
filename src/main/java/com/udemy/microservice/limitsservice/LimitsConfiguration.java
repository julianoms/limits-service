package com.udemy.microservice.limitsservice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LimitsConfiguration {

    private Integer maximum;
    private Integer minimum;
}
