# 🚀 Smart Irrigation Alert Dashboard — Master Checkpoint Tracker
**Student:** Chetan Katkar | **Roll No:** 23102A0024 | **Class:** BE CMPN-A  
**Subject:** DevOps (Academic Year 2026-27, Odd Sem)

> Mark each checkpoint `[x]` as you complete it. Save screenshots in the respective `Task-XX` folder.

---

## 📋 TASK 1 — Problem Definition and Scope
**Folder:** `Task-01_Problem-Definition/`  
**What to save here:** problem_statement.md, stakeholder_list.md, scope_document.md

- [x] **1.1** Research what a Smart Irrigation Alert Dashboard does in the real world
- [x] **1.2** List at least 3 target users (e.g., farmers, admins, agronomists)
- [x] **1.3** Identify 3–5 existing pain points (manual checking, water waste, etc.)
- [x] **1.4** List all stakeholders (farmers, IoT providers, government bodies)
- [x] **1.5** Document constraints (technical, budget, time)
- [x] **1.6** Define 3–4 measurable success criteria (response time, uptime, etc.)
- [x] **1.7** Write and freeze the MVP scope covering 5 core features:
  - [x] Data/Event Entry
  - [x] Searchable Dashboard
  - [x] Summary Indicators
  - [x] Status Drill-Down
  - [x] Alert/Exception View
- [x] **1.8** Save final `problem_statement.md` in the Task-01 folder

**✅ Deliverable:** Problem statement, stakeholder list, objectives, constraints, approved MVP scope.

---

## 📋 TASK 2 — Agile Planning and DevOps Workflow
**Folder:** `Task-02_Agile-Planning/`  
**What to save here:** user_stories.md, backlog.md, sprint_plan.md, devops_diagram.md

- [x] **2.1** Write at least 5 user stories with acceptance criteria  
  - [x] User Story 1: View real-time moisture dashboard
  - [x] User Story 2: Get alerts when moisture is low
  - [x] User Story 3: Add new sensor zones
  - [x] User Story 4: Search/filter sensor data
  - [x] User Story 5: View zone detail/drill-down
- [x] **2.2** Create a product backlog (ordered list of all features)
- [x] **2.3** Create a 15-Task Kanban board (use Trello / GitHub Projects / Markdown table)
- [x] **2.4** Write the Definition of Done (DoD) checklist
- [x] **2.5** Draw a DevOps lifecycle diagram (Plan → Code → Build → Test → Deploy → Operate → Monitor)
  - [x] Save the diagram in `Task-02_Agile-Planning/`
- [x] **2.6** Save everything in the Task-02 folder

**✅ Deliverable:** Backlog, task board, sprint plan, Definition of Done, DevOps workflow diagram.

---

## 📋 TASK 3 — Requirements, Architecture and Technology Setup
**Folder:** `Task-03_Architecture-Setup/`  
**What to save here:** srs_summary.md, architecture_diagram.png, api_list.md, local_setup_screenshot.png

- [x] **3.1** Write a short SRS summary (1–2 pages covering functional & non-functional requirements)
- [x] **3.2** Draw a use-case diagram (actors: Farmer, Admin; use-cases: View Dashboard, Add Zone, Get Alert)
- [x] **3.3** Draw an architecture diagram (Frontend → Backend → Database → Alerts)
- [x] **3.4** Select and document the technology stack:
  - [x] Language: Java (Spring Boot)
  - [x] Build tool: Maven
  - [x] Database: H2 / SQLite (embedded)
  - [x] Deployment: Tomcat (embedded) / Nginx
  - [x] CI/CD: Jenkins
  - [x] Testing: Selenium WebDriver
  - [x] Config Management: Ansible
- [x] **3.5** Define the data model (Sensor: id, zoneName, moistureLevel, temperature, status, lastUpdated)
- [x] **3.6** List all REST APIs:
  - [x] `GET /api/sensors`
  - [x] `POST /api/sensors`
  - [x] `GET /api/alerts`
  - [x] `POST /api/simulate`
- [x] **3.7** Set up local development environment (install JDK, Maven, IDE)
- [x] **3.8** Take a screenshot of the working local setup
- [x] **3.9** Save all documents and screenshots in the Task-03 folder

**✅ Deliverable:** SRS summary, use-case diagram, architecture diagram, data model/API list, working local setup.

---

## 📋 TASK 4 — Git and GitHub Repository Initialization
**Folder:** `Task-04_Git-GitHub-Init/`  
**What to save here:** repo_url.md, screenshots of commits, branch_policy.md

- [x] **4.1** Create a new GitHub repository named `DevOps-Project`
- [x] **4.2** Add a proper `README.md` with project title, description, tech stack, and setup instructions
- [x] **4.3** Add a `.gitignore` file (for Java/Maven: target/, *.class, .idea/, etc.)
- [x] **4.4** Set up folder structure in the repo:
  ```
  src/main/java/...
  src/main/resources/
  src/test/java/...
  pom.xml
  ```
- [x] **4.5** Add an issue template (bug report + feature request)
- [x] **4.6** Define branch naming convention:
  - [x] `main` — production-ready code
  - [x] `develop` — integration branch
  - [x] `feature/<name>` — feature branches
- [x] **4.7** Make the initial commit with a meaningful message (e.g., "Initial project skeleton with Maven and Spring Boot")
- [x] **4.8** Push to GitHub and verify the repo is visible online
- [x] **4.9** Create 3–5 GitHub Issues for upcoming features
- [x] **4.10** Screenshot the repo page, commit history, and issues page
- [x] **4.11** Save repo URL and all screenshots in the Task-04 folder

**✅ Deliverable:** Repository URL, README, initial commits, issues, branch policy.

---

## 📋 TASK 5 — Feature Development with Branching
**Folder:** `Task-05_Feature-Branching/`  
**What to save here:** feature_code_screenshots.png, pr_screenshot.png, merge_evidence.png

- [x] **5.1** Create a feature branch: `git checkout -b feature/sensor-dashboard`
- [x] **5.2** Implement the first core feature — Sensor Dashboard page:
  - [x] Create the controller to serve sensor data
  - [x] Create the HTML page to display sensor data in a table
  - [x] Add basic CSS styling
- [x] **5.3** Practice Git workflow:
  - [x] `git add .`
  - [x] `git commit -m "Add sensor dashboard feature"`
  - [x] `git push origin feature/sensor-dashboard`
  - [x] `git log --oneline` (screenshot the log)
- [x] **5.4** Raise a Pull Request on GitHub from `feature/sensor-dashboard` → `develop`
- [x] **5.5** Add review comments on the PR (self-review or peer-review)
- [x] **5.6** Merge the PR into the `develop` branch
- [x] **5.7** Screenshot: PR page, review comments, merge confirmation
- [x] **5.8** Save everything in the Task-05 folder

**✅ Deliverable:** Working feature 1, feature branch, pull request, review comments, merge evidence.

---

## 📋 TASK 6 — MVP Completion and Git Collaboration
**Folder:** `Task-06_MVP-Completion/`  
**What to save here:** mvp_screenshots.png, conflict_resolution.png, tag_screenshot.png

- [x] **6.1** Implement remaining MVP features on separate branches:
  - [x] **Data/Event Entry:** Form to add new sensor zone data
  - [x] **Searchable Dashboard:** Add search/filter functionality
  - [x] **Summary Indicators:** Show avg moisture, total alerts count
  - [x] **Status Drill-Down:** Click on a zone to see details
  - [x] **Alert/Exception View:** Highlight zones below moisture threshold
- [x] **6.2** Create a second feature branch: `feature/alert-system`
- [x] **6.3** Deliberately create a merge conflict:
  - [x] Edit the same file on both `develop` and `feature/alert-system`
  - [x] Try to merge → conflict appears
- [x] **6.4** Resolve the merge conflict manually
  - [x] Screenshot the conflict markers (`<<<<<<<`, `=======`, `>>>>>>>`)
  - [x] Screenshot the resolved file
- [x] **6.5** Tag the release: `git tag -a v1.0 -m "MVP Release v1.0"`
- [x] **6.6** Push the tag: `git push origin v1.0`
- [x] **6.7** Update the backlog (mark completed tasks)
- [x] **6.8** Test the full MVP in browser — screenshot the working app
- [x] **6.9** Save all evidence in the Task-06 folder

**✅ Deliverable:** Functional MVP, resolved merge conflict, tagged version, updated backlog.

---

## 📋 TASK 7 — Jenkins Installation and Continuous Integration Job
**Folder:** `Task-07_Jenkins-CI/`  
**What to save here:** jenkins_install.png, job_config.png, build_log.png, artefact.png

- [x] **7.1** Download and install Jenkins on your machine
  - [x] Download from https://www.jenkins.io/download/
  - [x] Run the installer / `java -jar jenkins.war`
  - [x] Screenshot the Jenkins setup wizard
- [x] **7.2** Install required plugins:
  - [x] Git Plugin
  - [x] Maven Integration Plugin
  - [x] Pipeline Plugin
- [x] **7.3** Configure JDK and Maven in Jenkins → Global Tool Configuration
- [x] **7.4** Create a new Freestyle Job named `smart-irrigation-ci`
- [x] **7.5** Connect it to your GitHub repository URL
- [x] **7.6** Configure build trigger:
  - [x] Option A: Poll SCM (e.g., `H/5 * * * *`)
  - [x] Option B: GitHub webhook (if possible)
- [x] **7.7** Add build step: `mvn clean package`
- [x] **7.8** Add post-build action: Archive the artifacts (`target/*.jar` or `target/*.war`)
- [x] **7.9** Run the build and verify it succeeds
- [x] **7.10** Screenshot: Job configuration, successful build console log, archived artefact
- [x] **7.11** Save all screenshots in the Task-07 folder

**✅ Deliverable:** Configured Jenkins job, successful build log, trigger evidence, archived artefact.

---

## 📋 TASK 8 — Pipeline as Code and Server Deployment
**Folder:** `Task-08_Pipeline-Deployment/`  
**What to save here:** Jenkinsfile, pipeline_run.png, deployed_app.png, config_evidence.png

- [x] **8.1** Create a `Jenkinsfile` in the project root with these stages:
  - [x] **Stage 1: Checkout** — `git checkout`
  - [x] **Stage 2: Build** — `mvn clean compile`
  - [x] **Stage 3: Package** — `mvn package`
  - [x] **Stage 4: Deploy** — Copy WAR/JAR to Tomcat or run via Docker
- [x] **8.2** Add at least one parameterized environment setting:
  - [x] e.g., `DEPLOY_ENV` = "staging" or "production"
  - [x] e.g., `APP_PORT` = "8085"
- [x] **8.3** Create a new Pipeline Job in Jenkins (not Freestyle)
- [x] **8.4** Point it to the Jenkinsfile in your GitHub repo
- [x] **8.5** Run the pipeline and verify all stages pass (green)
- [x] **8.6** Deploy the built application:
  - [x] If Tomcat: Copy .war to `webapps/` folder
  - [x] If embedded: Just run the .jar
- [x] **8.7** Open the deployed app in a browser — take screenshot
- [x] **8.8** Screenshot: Jenkinsfile content, pipeline stage view, deployed app
- [x] **8.9** Save Jenkinsfile and all screenshots in the Task-08 folder

**✅ Deliverable:** Jenkinsfile, successful pipeline run, deployed application URL/screenshot, configuration evidence.

---

## 📋 TASK 9 — Selenium Test Design and Local Execution
**Folder:** `Task-09_Selenium-Tests/`  
**What to save here:** test_plan.md, selenium_scripts/, test_report.png, failure_screenshot.png

- [x] **9.1** Identify 3–5 critical user journeys to test:
  - [x] Journey 1: Open dashboard and verify sensor data is displayed
  - [x] Journey 2: Add a new sensor zone and verify it appears
  - [x] Journey 3: Trigger a simulate action and verify alert appears
  - [x] Journey 4: Search for a specific zone
  - [x] Journey 5: Click on a zone for drill-down details
- [x] **9.2** Write the test plan document (what to test, expected results, test data)
- [x] **9.3** Add Selenium WebDriver dependency to `pom.xml`
- [x] **9.4** Write Selenium test classes in `src/test/java/`:
  - [x] `DashboardTest.java` — Verify dashboard loads with data
  - [x] `AddZoneTest.java` — Verify new zone creation
  - [x] `AlertTest.java` — Verify alert generation on low moisture
- [x] **9.5** Add assertions for each test (e.g., `assertEquals`, `assertTrue`)
- [x] **9.6** Implement screenshot-on-failure mechanism:
  ```java
  TakesScreenshot ts = (TakesScreenshot) driver;
  File src = ts.getScreenshotAs(OutputType.FILE);
  ```
- [x] **9.7** Run the tests locally: `mvn test`
- [x] **9.8** Screenshot: Test report output, any failure screenshots
- [x] **9.9** Save test plan, scripts, and screenshots in the Task-09 folder

**✅ Deliverable:** Test plan, Selenium scripts, local test report, failure screenshot mechanism.

---

## 📋 TASK 10 — Continuous Testing in Jenkins
**Folder:** `Task-10_Continuous-Testing/`  
**What to save here:** jenkins_test_report.png, failed_pipeline.png, defect_fix_commit.png, rerun.png

- [x] **10.1** Add a "Test" stage to the Jenkinsfile:
  ```groovy
  stage('Test') {
      steps {
          sh 'mvn test'
      }
      post {
          always {
              junit 'target/surefire-reports/*.xml'
          }
      }
  }
  ```
- [x] **10.2** Configure the pipeline so that failed tests STOP deployment
  - [x] Use `post { failure { ... } }` or make deploy stage conditional
- [x] **10.3** Run the pipeline — verify tests pass and report is published
- [x] **10.4** Deliberately introduce a defect in the code:
  - [x] e.g., Change a threshold value so an alert doesn't trigger correctly
  - [x] Commit and push the broken code
- [x] **10.5** Run pipeline again — it should FAIL at the test stage
  - [x] Screenshot the failed pipeline view
  - [x] Screenshot the Jenkins test report showing failures
- [x] **10.6** Fix the defect — commit with message like "Fix: Corrected moisture threshold bug"
- [x] **10.7** Push the fix and rerun the pipeline — it should pass now
- [x] **10.8** Screenshot: Successful rerun with green stages
- [x] **10.9** Save all evidence in the Task-10 folder

**✅ Deliverable:** Jenkins test report, failed pipeline evidence, defect correction commit, successful rerun.

---

## 📋 TASK 11 — Docker Image and Container Lifecycle
**Folder:** `Task-11_Docker-Container/`  
**What to save here:** Dockerfile, docker_commands.md, container_screenshots/

- [x] **11.1** Install Docker Desktop (if not already installed)
- [x] **11.2** Create a `Dockerfile` in the project root:
  ```dockerfile
  FROM eclipse-temurin:21-jre-alpine
  COPY target/smart-irrigation-dashboard.jar app.jar
  EXPOSE 8085
  ENTRYPOINT ["java", "-jar", "/app/app.jar"]
  ```
- [x] **11.3** Build the Docker image:
  ```bash
  docker build -t smart-irrigation:v1.0 .
  ```
- [x] **11.4** Verify the image: `docker images` → screenshot
- [x] **11.5** Run the container:
  ```bash
  docker run -d -p 8086:8085 --name irrigation-app smart-irrigation:v1.0
  ```
- [x] **11.6** Verify the app: Open `http://localhost:8086` → screenshot
- [x] **11.7** Inspect container logs: `docker logs irrigation-app` → screenshot
- [x] **11.8** Practice full container lifecycle and screenshot each command:
  - [x] `docker stop irrigation-app`
  - [x] `docker start irrigation-app`
  - [x] `docker restart irrigation-app`
  - [x] `docker rm irrigation-app`
- [x] **11.9** Document all commands in `docker_commands.md`
- [x] **11.10** Save Dockerfile, commands doc, and all screenshots in the Task-11 folder

**✅ Deliverable:** Dockerfile, image details, Docker command log, running container evidence.

---

## 📋 TASK 12 — Jenkins-Docker Continuous Deployment
**Folder:** `Task-12_Jenkins-Docker-CD/`  
**What to save here:** updated_Jenkinsfile, dockerhub_screenshot.png, pipeline_screenshot.png

- [x] **12.1** Create a Docker Hub account (if you don't have one): https://hub.docker.com
- [x] **12.2** Add Docker Hub credentials in Jenkins → Manage Credentials
- [x] **12.3** Extend the Jenkinsfile with Docker stages:
  - [x] **Stage: Docker Build** — `docker build -t yourusername/smart-irrigation:${BUILD_NUMBER} .`
  - [x] **Stage: Docker Push** — `docker push yourusername/smart-irrigation:${BUILD_NUMBER}`
  - [x] **Stage: Docker Deploy** — Stop old container, run new one
- [x] **12.4** Run the full pipeline end-to-end:
  - [x] Commit → Jenkins Build → Test → Docker Build → Docker Push → Deploy
- [x] **12.5** Verify the versioned image on Docker Hub → screenshot
- [x] **12.6** Verify the running container serves the app → screenshot
- [x] **12.7** Screenshot the complete pipeline stage view (all green)
- [x] **12.8** Save updated Jenkinsfile and screenshots in the Task-12 folder

**✅ Deliverable:** Versioned image, registry evidence, end-to-end commit-to-container pipeline.

---

## 📋 TASK 13 — Configuration Management Script
**Folder:** `Task-13_Config-Management/`  
**What to save here:** config_spec.md, ansible/ (inventory + playbook), execution_log.png

- [x] **13.1** List all server prerequisites:
  - [x] Packages: JDK 21, Docker, Git, Maven
  - [x] Users: `appuser` (non-root user for the application)
  - [x] Folders: `/opt/smart-irrigation/`, `/var/log/irrigation/`
  - [x] Files: `application.properties` config file
  - [x] Ports: 8085 (app), 8080 (Jenkins if on same node)
  - [x] Services: Docker daemon, application service
- [x] **13.2** Write configuration specification document (`config_spec.md`)
- [x] **13.3** Install Ansible (or Puppet):
  - [x] For Ansible: `pip install ansible` or use WSL
- [x] **13.4** Create Ansible inventory file (`inventory.ini`):
  ```ini
  [webservers]
  localhost ansible_connection=local
  ```
- [x] **13.5** Create Ansible playbook (`setup.yml`):
  - [x] Task: Install required packages
  - [x] Task: Create application user
  - [x] Task: Create required directories
  - [x] Task: Copy configuration files
  - [x] Task: Ensure Docker service is running
  - [x] Task: Deploy the Docker container
- [x] **13.6** Run the playbook: `ansible-playbook -i inventory.ini setup.yml`
- [x] **13.7** Screenshot the execution output
- [x] **13.8** Save all files and screenshots in the Task-13 folder

**✅ Deliverable:** Configuration specification, Ansible playbook, first execution log.

---

## 📋 TASK 14 — Automated Provisioning and Reliability Validation
**Folder:** `Task-14_Provisioning-Validation/`  
**What to save here:** idempotency_log.png, health_check.png, rollback_demo.png

- [x] **14.1** Provision a clean target environment:
  - [x] Option A: Use a fresh VM (VirtualBox / WSL)
  - [x] Option B: Use localhost with a clean state
- [x] **14.2** Run Ansible playbook on the clean target to set up everything from scratch
- [x] **14.3** Screenshot the provisioned environment with the app running
- [x] **14.4** Demonstrate idempotency:
  - [x] Run the SAME playbook again on the already-provisioned node
  - [x] Verify: Output shows "ok" (no changes), NOT "changed"
  - [x] Screenshot showing idempotent run
- [x] **14.5** Perform a health check:
  - [x] `curl http://localhost:8085/api/sensors` → should return data
  - [x] Screenshot the health-check result
- [x] **14.6** Test rollback/recovery:
  - [x] Deploy v2.0 (with a deliberate change)
  - [x] Detect a problem (e.g., a test fails)
  - [x] Rollback to v1.0 by re-deploying the previous Docker image tag
  - [x] Verify rollback is successful → screenshot
- [x] **14.7** Save all evidence in the Task-14 folder

**✅ Deliverable:** Provisioned node, idempotency evidence, health-check result, rollback/recovery demonstration.

---

## 📋 TASK 15 — Final End-to-End Release, Documentation and Viva
**Folder:** `Task-15_Final-Release-Docs/`  
**What to save here:** final_report.md, presentation.pptx, demo_video.mp4, troubleshooting.md

- [x] **15.1** Run the COMPLETE end-to-end workflow one final time:
  - [x] `git commit` → GitHub
  - [x] Jenkins build triggered automatically
  - [x] Maven build + Selenium test (quality gate)
  - [x] Docker image built and pushed
  - [x] Container deployed via Ansible
  - [x] App accessible in browser
- [x] **15.2** Record a screen recording / video of the full pipeline run
- [x] **15.3** Write the final technical report covering:
  - [x] Introduction & Problem Statement
  - [x] Architecture & Tech Stack
  - [x] Implementation Details (Task 1–14 summary)
  - [x] Screenshots of each stage
  - [x] Troubleshooting Guide (common errors and fixes)
  - [x] Limitations
  - [x] Future Enhancements
- [x] **15.4** Create a presentation (10–15 slides) for the viva:
  - [x] Slide 1: Title + Name + Roll No
  - [x] Slide 2: Problem Statement
  - [x] Slide 3: Architecture Diagram
  - [x] Slide 4: DevOps Pipeline Diagram
  - [x] Slide 5–6: Key Features (with screenshots)
  - [x] Slide 7: Git Workflow
  - [x] Slide 8: Jenkins CI/CD
  - [x] Slide 9: Docker
  - [x] Slide 10: Ansible
  - [x] Slide 11: Testing
  - [x] Slide 12: Demo
  - [x] Slide 13: Limitations & Future Work
  - [x] Slide 14: Conclusion
- [x] **15.5** Verify the final GitHub repo is clean and well-documented
- [x] **15.6** Practice the viva — be ready to explain:
  - [x] What is CI/CD?
  - [x] What is a Jenkinsfile?
  - [x] What is Docker? Dockerfile vs Image vs Container?
  - [x] What is Ansible? What is idempotency?
  - [x] How does your pipeline work end-to-end?
- [x] **15.7** Save final report, presentation, and video in the Task-15 folder

**✅ Deliverable:** Final repository, live demonstration, complete report, screenshots/video, presentation and viva.

---

## 🗂️ Folder Structure Reference
```
smart-irrigation-dashboard/
├── Task-01_Problem-Definition/
├── Task-02_Agile-Planning/
├── Task-03_Architecture-Setup/
├── Task-04_Git-GitHub-Init/
├── Task-05_Feature-Branching/
├── Task-06_MVP-Completion/
├── Task-07_Jenkins-CI/
├── Task-08_Pipeline-Deployment/
├── Task-09_Selenium-Tests/
├── Task-10_Continuous-Testing/
├── Task-11_Docker-Container/
├── Task-12_Jenkins-Docker-CD/
├── Task-13_Config-Management/
├── Task-14_Provisioning-Validation/
├── Task-15_Final-Release-Docs/
├── src/                          ← Your application source code
├── screenshots/                  ← General screenshots
├── pom.xml                       ← Maven config (created in Task 4)
├── Dockerfile                    ← Docker config (created in Task 11)
├── Jenkinsfile                   ← Jenkins pipeline (created in Task 8)
├── CHECKPOINTS.md                ← THIS FILE
└── README.md                     ← Project README
```

---

## ⏱️ Suggested Time Allocation
| Phase | Tasks | Estimated Time |
|-------|-------|---------------|
| Planning & Design | Task 1–3 | 2–3 days |
| Git & Development | Task 4–6 | 3–5 days |
| Jenkins CI/CD | Task 7–8 | 2–3 days |
| Testing | Task 9–10 | 2–3 days |
| Docker | Task 11–12 | 2–3 days |
| Config Management | Task 13–14 | 2–3 days |
| Final Documentation | Task 15 | 2–3 days |
| **TOTAL** | **15 Tasks** | **~15–23 days** |
