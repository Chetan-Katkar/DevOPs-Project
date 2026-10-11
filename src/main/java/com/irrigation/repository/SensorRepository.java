package com.irrigation.repository;

import com.irrigation.model.SensorZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<SensorZone, Long> {
    List<SensorZone> findByStatus(String status);
    List<SensorZone> findByMoistureLevelLessThan(double threshold);
}
