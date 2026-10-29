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
| **Ansible user** | A user with Docker CLI/daemon access on the target | Runs Docker without changing socket permissions |
| **Directories** | `~/.local/share/smart-irrigation/`, `~/.local/state/smart-irrigation/` | Writable deployment and state directories |
| **Network Ports** | `8085` (container), `8087` (Ansible/Jenkins demo by default), `8080` (Jenkins UI) | Container and host port bindings |
| **Image** | `smart-irrigation:v1.0` must already exist on the target | Container image deployed by the playbook |

The playbook verifies Docker availability, checks the requested local image, and only replaces the project-named container when its image, running state, port, or restart policy differs. It does not install Docker or grant users access to the Docker socket.
