package com.example.server.services;

import com.example.server.entities.BpmEntity;
import com.example.server.repos.BpmRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BpmService {

    private final BpmRepo bpmRepo;

    public BpmService(BpmRepo bpmRepo) {
        this.bpmRepo = bpmRepo;
    }

    public void saveBpm(BpmEntity bpm) {
        bpmRepo.save(bpm);
    }

    public List<BpmEntity> getAllBpm() {
        return bpmRepo.findAll();
    }

    public List<BpmEntity> getDailyBpm() {
        long endTime = System.currentTimeMillis();
        long startTime = endTime - 24 * 60 * 60 * 1000L;

        return bpmRepo.findAllByTimestampBetweenOrderByTimestamp(startTime, endTime);
    }
}
