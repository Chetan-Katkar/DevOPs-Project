# Ubuntu Demo Readiness Checklist

**Project:** Jenkins-Based Smart Irrigation Alert Dashboard
**Student:** Chetan Katkar — 23102A0024, BE CMPN-A
**Review date:** 29 October 2026

## Confirmed from the Ubuntu terminal output shared in this conversation

- The website and API respond at `http://localhost:8085`; the summary reported five zones, two critical alerts, and two optimal zones.
- Docker Desktop is running in the `desktop-linux` context. The `smart-irrigation:v1.0` image was run as container `irrigation-demo` on host port `8086`; `/api/summary` returned the expected data.
- Jenkins is running at `http://localhost:8080`. The `JDK 21` and `Maven 3.9` global tool entries were saved.
- The Jenkins Pipeline job previously completed build #2 successfully, passed five API tests, published a JUnit report, and archived the application JAR.
- GitHub SSH authentication and a push to `main` succeeded for commit `8ba5bf7`.

## Repository work completed in this update

- Added five Selenium browser journeys for page load, crop search, critical-status filtering, zone creation, and irrigation recovery. Run them with `mvn -Pselenium test`.
- Replaced the Jenkins placeholder deployment message with optional Selenium and Docker stages. Both are gated by build parameters so the normal compile/test/package pipeline does not require browser or daemon access.
- Reworked the Ansible playbook to detect the desired container state, avoid recreating a matching container, health-check deployment, and attempt rollback to the prior image.
- Corrected the Task 8–14 descriptions so they do not claim unrecorded Selenium, Docker CD, defect-injection, idempotency, or rollback results.
- The five API tests pass in this workspace. The Selenium test class compiles. It has not been run because this execution environment has no Chrome/Chromium.

These repository edits are local and not yet committed or pushed. The Jenkins build #2 screenshot/log is from the previous Jenkinsfile revision; run a new build after pushing to verify the updated pipeline.

## Remaining hands-on steps before the demo

### 1. Push the updated project

From the repository root:

```bash
cd ~/Desktop/DevOps-Project/DevOPs-Project
git status -sb
git add Jenkinsfile pom.xml src/test Task-08_Pipeline-Deployment Task-09_Selenium-Tests Task-10_Continuous-Testing Task-12_Jenkins-Docker-CD Task-13_Config-Management Task-14_Provisioning-Validation Task-15_Final-Release-Docs/Ubuntu_Demo_Readiness_Checklist.md
git commit -m "Add Selenium coverage and reliable deployment automation"
git push origin main
```

### 2. Verify the updated Jenkins pipeline

Run `smart-irrigation-pipeline` once after the push. Keep `RUN_SELENIUM` and `DEPLOY_DOCKER` unchecked for the first run. Confirm compile, five API tests, JUnit report, and JAR archive succeed. The older Freestyle job `built1` only checked out source; use the Pipeline job for the demo.

### 3. Enable browser tests

Install Chrome or Chromium on the Jenkins agent (or connect a Selenium Grid). Then check `RUN_SELENIUM` and run the job again. For Grid, set `SELENIUM_REMOTE_URL` and `SELENIUM_HOST` to a hostname the Grid browser can use to reach the test server. Save the test report and any `target/selenium-failures/*.png` output.

### 4. Run Ansible and capture real evidence

Install Ansible if needed, then run from the repository root:

```bash
sudo apt update
sudo apt install -y ansible
docker build -t smart-irrigation:v1.0 .
cd Task-13_Config-Management/ansible
ansible-playbook -i inventory.ini --syntax-check setup.yml
ansible-playbook -i inventory.ini setup.yml
ansible-playbook -i inventory.ini setup.yml
```

Capture both play recaps and check `curl -fsS http://localhost:8087/api/summary`. Do not claim `changed=0` or a demonstrated rollback until the actual run shows it.

### 5. Configure Jenkins Docker access only if demonstrating automated deployment

The updated pipeline uses the `DEPLOY_DOCKER` parameter and a separate demo container name and default host port `8087`. Jenkins must be able to run `docker info` before enabling this option. Do not use the existing `irrigation-demo` container as the Jenkins target. Granting the Jenkins service account access to the Docker socket is effectively root access; use a dedicated, isolated deployment agent/daemon for a demo, or leave this stage disabled and show the working Docker container manually.

### 6. Capture current screenshots

Save fresh screenshots of the website at `8085`, Docker Desktop showing `smart-irrigation:v1.0` and `irrigation-demo` at `8086`, Jenkins build/test report, GitHub `main`, and the Ansible second-run recap. Refresh the final portfolio document with those actual results before submission.
