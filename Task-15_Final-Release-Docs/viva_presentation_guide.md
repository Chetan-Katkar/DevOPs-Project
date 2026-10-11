# Viva Preparation & Presentation Guide (Task 15)

**Student Name:** Chetan Katkar | **Roll No:** 23102A0024 | **Class:** BE CMPN-A  
**Subject:** DevOps Engineering | **Academic Year:** 2026-27  

---

## 🎤 Top Viva Questions & Model Answers

### Q1: What is DevOps and why is it important in precision agriculture?
**Answer:** DevOps is a set of practices combining software development (Dev) and IT operations (Ops) to shorten the systems development life cycle while delivering features and fixes reliably. In precision agriculture, continuous monitoring and rapid deployments ensure sensors, pumps, and alert engines operate with zero downtime, preventing crop damage and water waste.

---

### Q2: What is CI/CD and what tools were used in this project?
**Answer:** 
- **CI (Continuous Integration):** Automatically compiling and testing code on every commit using **Jenkins** and **JUnit/Selenium** to catch integration defects early.
- **CD (Continuous Delivery/Deployment):** Automatically packaging the build into an executable artifact/Docker image and provisioning it to the target runtime environment.

---

### Q3: What is Pipeline as Code and what is the role of a `Jenkinsfile`?
**Answer:** Pipeline as Code means defining the entire CI/CD workflow in a version-controlled text file (`Jenkinsfile`) rather than configuring manual UI clicks. Benefits include auditability, branch-specific pipelines, and disaster recovery.

---

### Q4: Explain the difference between a Dockerfile, Image, and Container.
**Answer:**
- **Dockerfile:** A text recipe containing instructions on how to assemble the runtime.
- **Docker Image:** A lightweight, read-only, standalone executable package built from the Dockerfile.
- **Docker Container:** A live, running instance of an image executed in an isolated OS user space.

---

### Q5: What is Configuration Management and what is Ansible Idempotency?
**Answer:** 
- Configuration management automates server setup, package installation, and security baselines.
- **Idempotency** guarantees that applying an Ansible playbook multiple times leaves the system in the exact same state without unintended side effects (`changed=0` on subsequent runs).

---

## 📊 Presentation Slide Structure (12 Slides)
- **Slide 1:** Project Title, Student Info, Department
- **Slide 2:** Agricultural Problem Statement & Existing Inefficiencies
- **Slide 3:** Proposed Solution & 5 Core MVP Capabilities
- **Slide 4:** Architecture Diagram (Presentation $\rightarrow$ Spring Boot $\rightarrow$ H2 DB)
- **Slide 5:** End-to-End DevOps Lifecycle (Plan to Monitor)
- **Slide 6:** Git Branching Strategy & Pull Request Workflow
- **Slide 7:** Jenkins CI/CD Declarative Pipeline & Stage View
- **Slide 8:** Automated Quality Gate (JUnit & Selenium Testing)
- **Slide 9:** Docker Containerization & Registry Distribution
- **Slide 10:** Ansible Automated Provisioning & Idempotency
- **Slide 11:** Live Application Screenshots & Alert Verification
- **Slide 12:** Conclusion & Future Scope (IoT Hardware, ML Forecasting)
