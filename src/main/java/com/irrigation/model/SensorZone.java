package com.irrigation.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_zones")
public class SensorZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String zoneName;

    @Column(nullable = false)
    private String cropType;

    @Column(nullable = false)
    private double moistureLevel;

    @Column(nullable = false)
    private double temperature;

    @Column(nullable = false)
    private String status;

    private LocalDateTime lastUpdated;

    public SensorZone() {
        this.lastUpdated = LocalDateTime.now();
    }

    public SensorZone(String zoneName, String cropType, double moistureLevel, double temperature, String status, LocalDateTime lastUpdated) {
        this.zoneName = zoneName;
        this.cropType = cropType;
        this.moistureLevel = moistureLevel;
        this.temperature = temperature;
        this.status = status;
        this.lastUpdated = lastUpdated != null ? lastUpdated : LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public double getMoistureLevel() {
        return moistureLevel;
    }

    public void setMoistureLevel(double moistureLevel) {
        this.moistureLevel = moistureLevel;
        updateStatus();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void updateStatus() {
        if (this.moistureLevel < 30.0) {
            this.status = "CRITICAL";
        } else if (this.moistureLevel <= 60.0) {
            this.status = "OPTIMAL";
        } else {
            this.status = "SATURATED";
        }
    }
}
