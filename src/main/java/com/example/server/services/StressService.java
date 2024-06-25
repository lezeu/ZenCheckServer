package com.example.server.services;

import com.example.server.entities.StressEntity;
import com.example.server.repos.StressRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class StressService {
    private final StressRepo stressRepo;

    public StressService(StressRepo stressRepo) {
        this.stressRepo = stressRepo;
    }

    public void saveStress(StressEntity entity) {
        stressRepo.save(entity);
    }

    public List<StressEntity> getAllStress() {
        return stressRepo.findAll();
    }

    public List<StressEntity> getDailyStress() {
        long endTime = System.currentTimeMillis();
        long startTime = endTime - 24 * 60 * 60 * 1000L;

        return  stressRepo.findAllByTimestampBetweenOrderByTimestamp(startTime, endTime);
    }

    public List<StressEntity> getHourStress(int hour) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime timestamp;

        if (hour > now.getHour()) {
            timestamp = now.minusDays(1).withHour(hour).withMinute(0).withSecond(0).withNano(0);
        } else {
            timestamp = now.withHour(hour).withMinute(0).withSecond(0).withNano(0);
        }

        long startTime = timestamp.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000L;
        long endTime = startTime + 60 * 60 * 1000L;

        return  stressRepo.findAllByTimestampBetweenOrderByTimestamp(startTime, endTime);
    }
}
