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
| **TC-01** | Dashboard startup | Browser dashboard | Shows five seeded zones and the matching summary cards. |
| **TC-02** | Search by crop | Search field | Searching for Wheat displays the matching zone only. |
| **TC-03** | Status filter | Status selector | Critical filter displays only zones marked CRITICAL. |
| **TC-04** | Add a zone | Add Zone dialog | Submitting a zone displays it in the table. |
| **TC-05** | Irrigation recovery | Zone details dialog | Irrigating the Wheat zone updates it to 75% and SATURATED. |

---

## ⚙️ 3. Test Execution Command
The API tests run by default:
```bash
mvn test
```

The Selenium browser tests are isolated in the `selenium` Maven profile, so normal builds do not require a browser:
```bash
mvn -Pselenium test
```

Install Chrome or Chromium on the test agent. Selenium Manager can locate/download the matching driver when the agent has network access. Alternatively set `SELENIUM_REMOTE_URL` to a reachable Selenium Grid URL and `SELENIUM_HOST` to the hostname that the Grid browser uses to reach the test server. Jenkins runs this profile only when `RUN_SELENIUM` is enabled.

API and browser test reports are written to `target/surefire-reports/`. Browser screenshots captured on test failures are saved under `target/selenium-failures/`.

**Execution status:** the five API tests have passed in Jenkins. The Selenium tests are implemented but still need to be run on an agent with Chrome/Chromium or Selenium Grid.
