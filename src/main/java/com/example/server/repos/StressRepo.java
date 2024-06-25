package com.example.server.repos;

import com.example.server.entities.StressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StressRepo extends JpaRepository<StressEntity, Long> {
    List<StressEntity> findAllByTimestampBetween(long start, long end);
    List<StressEntity> findAllByTimestampBetweenOrderByTimestamp(long start, long end);
}
