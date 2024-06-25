package com.example.server.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StressDto {
    private String stressLevel;
    private float hr;
    private float sdnn;
    private float rmssd;
    private long timestamp;
}
