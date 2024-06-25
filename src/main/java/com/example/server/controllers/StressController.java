package com.example.server.controllers;

import com.example.server.dtos.StressDto;
import com.example.server.entities.StressEntity;
import com.example.server.services.StressService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stress")
public class StressController {
    private final StressService stressService;

    public StressController(StressService stressService) {
        this.stressService = stressService;
    }

    @PostMapping
    public StressDto saveStress(@RequestBody StressDto stressDto) {
        StressEntity stressEntity = new StressEntity();
        stressEntity.setStressLevel(stressDto.getStressLevel());
        stressEntity.setHr(stressDto.getHr());
        stressEntity.setSdnn(stressDto.getSdnn());
        stressEntity.setRmssd(stressDto.getRmssd());
        stressEntity.setTimestamp(stressDto.getTimestamp());

        stressService.saveStress(stressEntity);
        return stressDto;
    }

    @GetMapping
    public List<StressEntity> getStress() {
        return stressService.getAllStress();
    }

    @GetMapping("/daily")
    public List<StressEntity> getDailyStress() {
        return stressService.getDailyStress();
    }

    @GetMapping("/hour")
    public List<StressEntity> getHourStress(@Param("hour") int hour) {
        return stressService.getHourStress(hour);
    }
}
