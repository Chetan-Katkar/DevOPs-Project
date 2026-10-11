package com.irrigation.controller;

import com.irrigation.model.SensorZone;
import com.irrigation.repository.SensorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SensorApiController {

    private final SensorRepository repository;
    private final Random random = new Random();

    public SensorApiController(SensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/sensors")
    public List<SensorZone> getAllSensors() {
        return repository.findAll();
    }

    @PostMapping("/sensors")
    public ResponseEntity<SensorZone> createSensor(@RequestBody SensorZone sensor) {
        if (sensor.getZoneName() == null || sensor.getZoneName().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        sensor.updateStatus();
        sensor.setLastUpdated(LocalDateTime.now());
        SensorZone saved = repository.save(sensor);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/alerts")
    public Map<String, Object> getAlerts() {
        List<SensorZone> criticalZones = repository.findByMoistureLevelLessThan(30.0);
        Map<String, Object> response = new HashMap<>();
        response.put("totalAlerts", criticalZones.size());
        response.put("criticalThreshold", 30.0);
        response.put("alerts", criticalZones);
        return response;
    }

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {
        List<SensorZone> zones = repository.findAll();
        double avgMoisture = zones.stream().mapToDouble(SensorZone::getMoistureLevel).average().orElse(0.0);
        long criticalCount = zones.stream().filter(z -> z.getMoistureLevel() < 30.0).count();
        long optimalCount = zones.stream().filter(z -> z.getMoistureLevel() >= 30.0 && z.getMoistureLevel() <= 60.0).count();

        Map<String, Object> summary = new HashMap<>();
        summary.put("totalZones", zones.size());
        summary.put("avgMoisture", Math.round(avgMoisture * 10.0) / 10.0);
        summary.put("criticalAlerts", criticalCount);
        summary.put("optimalZones", optimalCount);
        return summary;
    }

    @PostMapping("/simulate")
    public ResponseEntity<Map<String, String>> simulateFluctuation() {
        List<SensorZone> zones = repository.findAll();
        for (SensorZone zone : zones) {
            double delta = (random.nextDouble() * 10.0) - 5.0; // -5% to +5%
            double newMoisture = Math.max(5.0, Math.min(95.0, zone.getMoistureLevel() + delta));
            double newTemp = Math.max(15.0, Math.min(45.0, zone.getTemperature() + (random.nextDouble() * 2.0 - 1.0)));

            zone.setMoistureLevel(Math.round(newMoisture * 10.0) / 10.0);
            zone.setTemperature(Math.round(newTemp * 10.0) / 10.0);
            zone.updateStatus();
            zone.setLastUpdated(LocalDateTime.now());
            repository.save(zone);
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", "Simulated IoT sensor readings updated successfully.");
        response.put("timestamp", LocalDateTime.now().toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sensors/{id}/irrigate")
    public ResponseEntity<SensorZone> triggerIrrigation(@PathVariable Long id) {
        return repository.findById(id).map(zone -> {
            zone.setMoistureLevel(75.0);
            zone.updateStatus();
            zone.setLastUpdated(LocalDateTime.now());
            SensorZone updated = repository.save(zone);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
}
