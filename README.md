# 🌾 Smart Irrigation Alert Dashboard

**Author:** Chetan Katkar  
**Roll No:** 23102A0024  
**Class:** BE CMPN-A (Vidyalankar Institute of Technology)  
**Subject:** DevOps Project (Academic Year 2026-27)  

---

## 📖 Overview
The **Smart Irrigation Alert Dashboard** is a production-grade DevOps demonstration project built with **Java 21, Spring Boot, Maven, Selenium, Docker, Jenkins, and Ansible**. It simulates multi-zone agricultural IoT soil sensors, evaluates critical soil moisture thresholds (< 30%), and triggers automated visual alerts to prevent water waste and crop dehydration.

---

## 🛠️ DevOps Technology Stack
- **Backend:** Java 21 LTS, Spring Boot 3.2.x, Spring Data JPA
- **Database:** Embedded H2 Database
- **Frontend:** HTML5, CSS3, JavaScript, Bootstrap Icons
- **Build & Dependency Management:** Apache Maven 3.9+
- **Version Control:** Git & GitHub (GitFlow Branching)
- **Continuous Integration (CI):** Jenkins (Declarative Pipeline)
- **Continuous Testing:** Selenium WebDriver & JUnit 5
- **Containerization:** Docker & Docker Hub
- **Configuration Management:** Ansible Playbooks

---

## 🚀 Quick Start (Local Run)

### Prerequisites:
- Java JDK 17 or 21
- Apache Maven 3.8+

### Build & Run:
```bash
# Clone the repository
git clone https://github.com/<your-username>/smart-irrigation-dashboard.git
cd smart-irrigation-dashboard

# Run using Maven
mvn clean spring-boot:run
```

Access the web dashboard in your browser:  
👉 **`http://localhost:8080`**

---

## 📋 5 Core MVP Features
1. **Data/Event Entry:** Form to simulate and input new sensor zone data.
2. **Searchable Dashboard:** Search zones by name and filter by status.
3. **Summary Indicators:** Real-time KPI cards for Average Moisture, Active Zones, and Critical Alerts.
4. **Status Drill-Down:** Detailed view of zone history with one-click irrigation triggers.
5. **Alert/Exception View:** Automated visual highlighting of zones below 30% moisture threshold.
