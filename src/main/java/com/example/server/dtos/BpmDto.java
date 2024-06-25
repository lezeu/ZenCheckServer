package com.example.server.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BpmDto {
    private float bpmAverage;
    private float bpmHigh;
    private float bpmLow;
    private long timestamp;
}
