package com.irrigation;

import com.irrigation.model.SensorZone;
import com.irrigation.repository.SensorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SmartIrrigationUiIT {

    @LocalServerPort
    private int port;

    @Autowired
    private SensorRepository repository;

    private WebDriver driver;
    private WebDriverWait wait;

    @RegisterExtension
    final TestExecutionExceptionHandler failureScreenshot = (context, failure) -> {
        if (driver instanceof TakesScreenshot screenshotDriver) {
            try {
                Path screenshotDirectory = Path.of("target", "selenium-failures");
                Files.createDirectories(screenshotDirectory);
                String filename = context.getRequiredTestMethod().getName() + ".png";
                Files.write(screenshotDirectory.resolve(filename), screenshotDriver.getScreenshotAs(OutputType.BYTES));
            } catch (Exception screenshotFailure) {
                failure.addSuppressed(screenshotFailure);
            }
        }
        throw failure;
    };

    @BeforeEach
    void openDashboard() throws Exception {
        resetSeedData();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1440,1200");

        String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");
        if (remoteUrl == null || remoteUrl.isBlank()) {
            driver = new ChromeDriver(options);
        } else {
            driver = new RemoteWebDriver(new URL(remoteUrl), options);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String appHost = System.getenv("SELENIUM_HOST");
        if (appHost == null || appHost.isBlank()) {
            appHost = "127.0.0.1";
        }
        driver.get("http://" + appHost + ":" + port + "/");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("kpiTotalZones"), "5"));
    }

    @AfterEach
    void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void dashboardLoadsSeededZonesAndSummaryCards() {
        assertTrue(driver.getTitle().contains("Smart Irrigation Alert Dashboard"));
        assertEquals("5", driver.findElement(By.id("kpiTotalZones")).getText());
        assertEquals("2", driver.findElement(By.id("kpiCriticalAlerts")).getText());
        assertEquals(5, rows().size());
    }

    @Test
    void searchFiltersZonesByCrop() {
        WebElement search = driver.findElement(By.id("searchInput"));
        search.sendKeys("Wheat");

        wait.until(d -> rows().size() == 1);
        assertTrue(rows().get(0).getText().contains("Wheat"));
    }

    @Test
    void statusFilterShowsOnlyCriticalZones() {
        new Select(driver.findElement(By.id("statusFilter"))).selectByValue("CRITICAL");

        wait.until(d -> rows().size() == 2);
        for (WebElement row : rows()) {
            assertTrue(row.getText().contains("CRITICAL"));
        }
    }

    @Test
    void addZoneFormCreatesAndDisplaysNewZone() {
        String zoneName = "Selenium Test Zone";
        driver.findElement(By.id("openAddModalBtn")).click();
        driver.findElement(By.id("newZoneName")).sendKeys(zoneName);
        driver.findElement(By.id("newCropType")).sendKeys("Tomato");
        driver.findElement(By.id("newMoisture")).clear();
        driver.findElement(By.id("newMoisture")).sendKeys("45");
        driver.findElement(By.id("newTemp")).clear();
        driver.findElement(By.id("newTemp")).sendKeys("26");
        driver.findElement(By.cssSelector("#addZoneForm button[type='submit']")).click();

        wait.until(d -> d.findElement(By.id("sensorTableBody")).getText().contains(zoneName));
        assertTrue(driver.findElement(By.id("sensorTableBody")).getText().contains(zoneName));
    }

    @Test
    void irrigationActionUpdatesCriticalZone() {
        WebElement wheatRow = rows().stream()
                .filter(row -> row.getText().contains("Zone A - Wheat Field"))
                .findFirst()
                .orElseThrow();
        wheatRow.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drillDownIrrigateBtn")));
        driver.findElement(By.id("drillDownIrrigateBtn")).click();

        wait.until(d -> rows().stream()
                .filter(row -> row.getText().contains("Zone A - Wheat Field"))
                .anyMatch(row -> row.getText().contains("75.0%") && row.getText().contains("SATURATED")));
        assertTrue(rows().stream()
                .filter(row -> row.getText().contains("Zone A - Wheat Field"))
                .anyMatch(row -> row.getText().contains("75.0%") && row.getText().contains("SATURATED")));
    }

    private List<WebElement> rows() {
        return driver.findElements(By.cssSelector("#sensorTableBody tr"));
    }

    private void resetSeedData() {
        repository.deleteAll();
        LocalDateTime now = LocalDateTime.now();
        repository.saveAll(List.of(
                new SensorZone("Zone A - Wheat Field", "Wheat", 22.0, 31.5, "CRITICAL", now.minusMinutes(5)),
                new SensorZone("Zone B - Apple Orchard", "Apple", 52.0, 26.0, "OPTIMAL", now.minusMinutes(2)),
                new SensorZone("Zone C - Rice Paddy", "Rice", 78.0, 29.0, "SATURATED", now.minusMinutes(1)),
                new SensorZone("Zone D - Cotton Section", "Cotton", 26.5, 33.0, "CRITICAL", now.minusMinutes(4)),
                new SensorZone("Zone E - Green Vegetable Greenhouse", "Vegetables", 48.0, 24.5, "OPTIMAL", now.minusMinutes(3))
        ));
    }
}
