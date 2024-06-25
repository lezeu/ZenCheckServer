package com.example.server.repos;

import com.example.server.entities.BpmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BpmRepo extends JpaRepository<BpmEntity, Long> {
    List<BpmEntity> findAllByTimestampBetweenOrderByTimestamp(long start, long end);
}
