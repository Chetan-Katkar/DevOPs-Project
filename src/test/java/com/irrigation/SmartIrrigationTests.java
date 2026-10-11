package com.irrigation;

import com.irrigation.model.SensorZone;
import com.irrigation.repository.SensorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SmartIrrigationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SensorRepository repository;

    @Test
    @DisplayName("TC-01: Verify sensor telemetry retrieval")
    public void testGetAllSensors() throws Exception {
        mockMvc.perform(get("/api/sensors"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))));
    }

    @Test
    @DisplayName("TC-02: Verify critical alert detection (<30% moisture)")
    public void testCriticalAlerts() throws Exception {
        mockMvc.perform(get("/api/alerts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.criticalThreshold", is(30.0)))
                .andExpect(jsonPath("$.totalAlerts", greaterThanOrEqualTo(1)));
    }

    @Test
    @DisplayName("TC-03: Verify dynamic zone registration")
    public void testAddNewZone() throws Exception {
        String newZoneJson = """
            {
                "zoneName": "Zone T - Test Greenhouse",
                "cropType": "Strawberries",
                "moistureLevel": 42.5,
                "temperature": 25.0
            }
        """;

        mockMvc.perform(post("/api/sensors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newZoneJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.zoneName", is("Zone T - Test Greenhouse")))
                .andExpect(jsonPath("$.status", is("OPTIMAL")));
    }

    @Test
    @DisplayName("TC-04: Verify global KPI calculations")
    public void testSummaryKpis() throws Exception {
        mockMvc.perform(get("/api/summary"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalZones", greaterThan(0)))
                .andExpect(jsonPath("$.avgMoisture", greaterThan(0.0)));
    }

    @Test
    @DisplayName("TC-05: Verify one-click irrigation restores moisture")
    public void testIrrigationTrigger() throws Exception {
        mockMvc.perform(post("/api/sensors/1/irrigate"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.moistureLevel", is(75.0)))
                .andExpect(jsonPath("$.status", is("SATURATED")));
    }
}
