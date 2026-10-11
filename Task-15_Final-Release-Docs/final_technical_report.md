# Final Technical Report — Smart Irrigation Alert Dashboard

**Project Title:** End-to-End DevOps Implementation for Smart Irrigation Alert Dashboard  
**Student Name:** Chetan Katkar  
**Roll Number:** 23102A0024  
**Class / Division:** BE CMPN-A  
**College:** Vidyalankar Institute of Technology, Mumbai  
**Subject:** DevOps (Academic Year 2026-27, Odd Semester)  

---

## 1. Executive Summary
The Smart Irrigation Alert Dashboard is an enterprise-grade precision agriculture platform developed to solve critical water waste and crop dehydration issues. By tracking real-time soil moisture and ambient temperature across partitioned agricultural zones, the system triggers automated visual alerts when hydration levels drop below a critical 30% safety threshold.

The primary objective of this project was to establish an automated, robust, and continuous end-to-end DevOps pipeline spanning Plan, Code, Build, Test, Release, Deploy, Operate, and Monitor.

---

## 2. Complete DevOps Toolchain Architecture

| Stage | Technology | Purpose & Responsibility |
|:------|:-----------|:-------------------------|
| **Planning** | Agile / Markdown Kanban | User stories, acceptance criteria, product backlog, sprint roadmap |
| **SCM** | Git & GitHub | GitFlow branching (`main`, `develop`, `feature/*`), PR code review |
| **Application** | Java 21 LTS, Spring Boot 3 | Modular backend REST APIs, JPA entities, H2 in-memory DB |
| **Frontend** | HTML5, CSS3, Vanilla JS | Interactive real-time dashboard, KPI indicators, drill-down modals |
| **Build** | Apache Maven 3.9 | Clean compilation, dependency management, executable fat JAR |
| **Testing** | JUnit 5 & MockMvc / Selenium | Automated quality gate regression testing |
| **CI/CD** | Jenkins Pipeline | Declarative Jenkinsfile driving automated stages |
| **Packaging** | Docker & Docker Hub | Multi-stage lightweight containerization, image versioning |
| **Config Mgmt** | Ansible | Automated idempotent server provisioning and deployments |
| **Reliability** | Health Checks & Rollbacks | Zero-downtime recovery and automated health endpoints |

---

## 3. Implementation Summary (Tasks 1 to 14)

### Tasks 1–3: Scoping, Agile Backlog & Architecture
- Defined 5 core MVP capabilities: Data Entry, Searchable Dashboard, Summary Indicators, Status Drill-Down, and Alert/Exception View.
- Authored 5 detailed User Stories (US-01 through US-05) with clear Definition of Done.
- Designed a 4-tier system architecture and published REST API contracts.

### Tasks 4–6: SCM Collaboration & MVP Realization
- Initialized public repository `https://github.com/Chetan-Katkar/DevOps-Project`.
- Implemented GitFlow branching strategy; merged `feature/sensor-dashboard` into `develop` via Pull Request.
- Deliberately created and successfully resolved a merge conflict on `README.md`.
- Released and tagged milestone `v1.0`.

### Tasks 7–10: Jenkins CI & Continuous Quality Gate
- Configured Jenkins Freestyle and Pipeline jobs with SCM polling.
- Penned declarative `Jenkinsfile` with parameterization (`DEPLOY_ENV`, `APP_PORT=8085`).
- Engineered automated regression test suite achieving 100% green pass rate (`5/5 tests passing`).
- Established an automated Quality Gate preventing broken code from progressing to deployment.

### Tasks 11–14: Containerization, Continuous Delivery & Provisioning
- Authored Dockerfile utilizing lightweight Java 21 runtime.
- Packaged, executed, and validated container lifecycle on port `8085`/`8086`.
- Drafted Ansible playbooks (`setup.yml`) demonstrating automated server provisioning and verified zero-change idempotency (`changed=0`).
- Documented automated health-check endpoints and rapid rollback disaster recovery.

---

## 4. Key Results & Achievements
- **Build Time:** Maven package completed in under 15 seconds.
- **Alert Latency:** Instant visual detection of $<30\%$ moisture in under 1 second.
- **Test Pass Rate:** 100% (5 out of 5 tests passing).
- **Portability:** Zero external database configuration required due to embedded H2 database.
