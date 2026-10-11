# Configuration Management Specification (Task 13)

**Project:** Smart Irrigation Alert Dashboard  
**Student:** Chetan Katkar | **Roll No:** 23102A0024 | **Class:** BE CMPN-A  

---

## 🖥️ Server Prerequisite Specification

| Parameter | Required Setting | Purpose |
|:----------|:-----------------|:--------|
| **Target OS** | Ubuntu 22.04 LTS / Debian / WSL / Windows | Deployment host system |
| **Java Runtime** | OpenJDK 21 LTS | Running Spring Boot backend |
| **Container Engine** | Docker CE 24+ / Docker Desktop | Running containerized application |
| **System User** | `appuser` (UID: 1001, GID: 1001) | Non-root security compliance |
| **Directories** | `/opt/smart-irrigation/`, `/var/log/irrigation/` | App binary and log storage |
| **Network Ports** | `8085` (Application), `8080` (Jenkins) | Port binding |
| **Environment File** | `/opt/smart-irrigation/application.env` | Runtime environment config |
