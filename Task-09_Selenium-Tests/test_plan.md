# Automated Test Plan & Strategy — Smart Irrigation Dashboard

**Project:** Smart Irrigation Alert Dashboard  
**Student:** Chetan Katkar | **Roll No:** 23102A0024 | **Class:** BE CMPN-A  

---

## 🎯 1. Testing Objectives & Scope
The automated test suite verifies the end-to-end functionality, reliability, and threshold detection of the Smart Irrigation Dashboard MVP before deployment through the CI/CD pipeline.

---

## 📋 2. Critical Test Journeys

| Test Case ID | Test Name | Target Component | Expected Result |
|:------------|:----------|:-----------------|:----------------|
| **TC-01** | Initial Sensor Feed Ingestion | `/api/sensors` | Returns status 200 OK with $\ge 5$ active zones populated. |
| **TC-02** | Low-Moisture Alert Detection | `/api/alerts` | Identifies zones with moisture $< 30\%$ and generates critical alert severity. |
| **TC-03** | Dynamic Zone Creation | `/api/sensors` (POST) | Successfully persists new zone and calculates correct status badge. |
| **TC-04** | Global Summary Metrics | `/api/summary` | Correctly aggregates average moisture and counts critical vs optimal zones. |
| **TC-05** | One-Click Irrigation Recovery | `/api/sensors/{id}/irrigate` | Updates moisture to $75\%$, restoring zone status to normal. |

---

## ⚙️ 3. Test Execution Command
Run the test suite locally via Maven:
```bash
mvn test
```

Test reports and surefire XML logs are archived automatically at:
`target/surefire-reports/`
