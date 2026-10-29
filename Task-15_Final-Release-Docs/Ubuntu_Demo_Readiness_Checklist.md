# Ubuntu Demo Readiness Checklist

Project: Jenkins-Based Smart Irrigation Alert Dashboard  
Student: Chetan Katkar - 23102A0024  
Review date: 29 October 2026

## What is present in the repository

- Java 21 / Spring Boot dashboard source and five seeded sensor zones.
- Maven project with five MockMvc integration tests.
- Jenkinsfile with checkout, compile, test, package, and artifact archive stages.
- Multi-stage Java 21 Dockerfile exposing container port 8085.
- Ansible inventory and deployment playbook.
- Git history includes the v1.0 tag and feature/merge commits.

## What this session could not verify

- A fresh Maven test run: Maven Central DNS failed in the restricted task environment.
- The app responding at localhost:8085: local socket access is restricted in this session.
- Docker image/container state: the desktop-linux context is listed, but Docker API access failed.
- Current Jenkins state: the session could not reach the host service. A saved Jenkins screenshot shows a blank dashboard and an offline built-in node.
- Ansible execution: ansible-playbook was not available in this task environment.

These results describe this task session. Re-run the checks from Ubuntu Terminal before the live demo.

## 1. Check GitHub and push the local commit

The local main branch was one commit ahead of origin/main during this review. GitHub does not accept an account password for HTTPS Git pushes. Set up SSH or use a personal access token; never put a token directly into a command or share it.

SSH option:

```bash
ssh-keygen -t ed25519 -C "your-github-email@example.com"
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519
cat ~/.ssh/id_ed25519.pub
```

Add the public key at GitHub Settings > SSH and GPG keys. Then run:

```bash
cd ~/Desktop/DevOps-Project/DevOPs-Project
git remote set-url origin git@github.com:Chetan-Katkar/DevOPs-Project.git
ssh -T git@github.com
git status -sb
git push origin main
```

## 2. Run the web application

Confirm Java 21 and Maven, then run the tests and application:

```bash
java -version
mvn -version
mvn test
mvn clean spring-boot:run
```

Keep the app terminal open. Visit http://localhost:8085 and check the API:

```bash
curl http://localhost:8085/api/sensors
curl http://localhost:8085/api/summary
curl http://localhost:8085/api/alerts
```

The README currently says port 8080, but application.properties sets the app port to 8085. Jenkins normally uses port 8080.

## 3. Build and show the Docker image/container

Start Docker Desktop from the app menu, or run:

```bash
systemctl --user start docker-desktop
docker context use desktop-linux
docker info
```

For Docker Engine instead, use `sudo systemctl start docker` and prefix Docker commands with `sudo` unless your user is configured for Docker access.

Build and launch the project container:

```bash
cd ~/Desktop/DevOps-Project/DevOPs-Project
docker build -t smart-irrigation:v1.0 .
docker rm -f irrigation-app 2>/dev/null || true
docker run -d --name irrigation-app -p 8086:8085 smart-irrigation:v1.0
curl http://localhost:8086/api/sensors
docker image ls smart-irrigation
docker ps --filter name=irrigation-app
docker logs irrigation-app
```

Open http://localhost:8086. In Docker Desktop, show the image under Images and the running app under Containers. The image exposes 8085 inside the container; the command publishes it on host port 8086.

## 4. Start and configure Jenkins

If Jenkins is missing, install the current Long-Term Support package. Jenkins requires Java 21 or later; the official Ubuntu instructions install Java before Jenkins and add the signed `debian-stable` package repository ([Jenkins Linux installation guide](https://www.jenkins.io/doc/book/installing/linux/)).

```bash
sudo apt update
sudo apt install -y fontconfig openjdk-21-jre
sudo install -d -m 0755 /etc/apt/keyrings
sudo wget -O /etc/apt/keyrings/jenkins-keyring.asc https://pkg.jenkins.io/debian-stable/jenkins.io-2026.key
echo "deb [signed-by=/etc/apt/keyrings/jenkins-keyring.asc]" https://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt update
sudo apt install -y jenkins
sudo systemctl enable --now jenkins
```

If Jenkins is already installed, skip that block. Check the package and service:

```bash
dpkg -s jenkins | head
sudo systemctl status jenkins --no-pager
sudo systemctl start jenkins
```

Open http://localhost:8080. If Jenkins is still on its first-run screen, get its unlock key with:

```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```

In Jenkins, verify the agent is online. Configure tool names `JDK 21` and `Maven 3.9`, then create a Pipeline job with:

- Definition: Pipeline script from SCM
- SCM: Git
- Repository: `https://github.com/Chetan-Katkar/DevOPs-Project.git`
- Branch: `*/main`
- Script path: `Jenkinsfile`

Run Build Now and save the Console Output, test report, and archived JAR evidence. The current Jenkinsfile's deploy stage prints a message; it does not deploy the app.

## 5. Fix the remaining assignment gaps before claiming full CI/CD

- Add Selenium WebDriver test classes and screenshot-on-failure handling. The current five tests use Spring MockMvc.
- Either describe Jenkins as CI/package-only or implement real Docker build, registry credentials, image push, deployment, and health check stages.
- Revise the Ansible playbook to manage packages, user, directories, configuration files, and container declaratively. Its current stop/remove/run sequence changes the container each run and is not idempotent.
- Run the playbook twice and preserve the actual first-run and second-run output. Do not use the documented `changed=0` result until the real second run shows it.
- Capture fresh Ubuntu screenshots for the website, Jenkins build, Docker image/container dashboard, health endpoint, and Ansible runs. Existing screenshots were captured earlier and are not current Ubuntu proof.
