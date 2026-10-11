package com.irrigation;

import com.irrigation.model.SensorZone;
import com.irrigation.repository.SensorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class SmartIrrigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartIrrigationApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(SensorRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new SensorZone("Zone A - Wheat Field", "Wheat", 22.0, 31.5, "CRITICAL", LocalDateTime.now().minusMinutes(5)));
                repository.save(new SensorZone("Zone B - Apple Orchard", "Apple", 52.0, 26.0, "OPTIMAL", LocalDateTime.now().minusMinutes(2)));
                repository.save(new SensorZone("Zone C - Rice Paddy", "Rice", 78.0, 29.0, "SATURATED", LocalDateTime.now().minusMinutes(1)));
                repository.save(new SensorZone("Zone D - Cotton Section", "Cotton", 26.5, 33.0, "CRITICAL", LocalDateTime.now().minusMinutes(4)));
                repository.save(new SensorZone("Zone E - Green Vegetable Greenhouse", "Vegetables", 48.0, 24.5, "OPTIMAL", LocalDateTime.now().minusMinutes(3)));
            }
        };
    }
}
