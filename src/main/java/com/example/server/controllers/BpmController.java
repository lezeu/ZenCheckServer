package com.example.server.controllers;

import com.example.server.dtos.BpmDto;
import com.example.server.entities.BpmEntity;
import com.example.server.services.BpmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bpm")
public class BpmController {

    private final BpmService bpmService;

    public BpmController(BpmService bpmService) {
        this.bpmService = bpmService;
    }

    @PostMapping
    public BpmDto saveBpm(@RequestBody BpmDto bpmDto) {
        BpmEntity bpmEntity = new BpmEntity();
        bpmEntity.setBpmAverage(bpmDto.getBpmAverage());
        bpmEntity.setBpmHigh(bpmDto.getBpmHigh());
        bpmEntity.setBpmLow(bpmDto.getBpmLow());
        bpmEntity.setTimestamp(bpmDto.getTimestamp());

        bpmService.saveBpm(bpmEntity);
        return bpmDto;
    }

    @GetMapping
    public List<BpmEntity> getAllBpm() {
        return bpmService.getAllBpm();
    }

    @GetMapping("/daily")
    public List<BpmEntity> getDailyBpm() {
        return bpmService.getDailyBpm();
    }
}
