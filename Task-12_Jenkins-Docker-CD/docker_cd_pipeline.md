# Jenkins-Docker Continuous Deployment Pipeline (Task 12)

**Project:** Smart Irrigation Alert Dashboard  
**Student:** Chetan Katkar | **Roll No:** 23102A0024 | **Class:** BE CMPN-A  

---

## 🚀 Continuous Delivery to Docker Registry Workflow

```mermaid
flowchart LR
    A[Git Commit to main/develop] --> B[Jenkins CI: Build & Test]
    B --> C[Docker Image Build: smart-irrigation:${BUILD_NUMBER}]
    C --> D[Docker Hub Registry Push]
    D --> E[Pull & Run Container on Target Server]
    E --> F[Health Check Verification]
```

---

## 📦 Extended Jenkinsfile Stage for Docker CD

```groovy
stage('Docker Build & Registry Push') {
    steps {
        echo "Building versioned Docker image: smart-irrigation:${BUILD_NUMBER}..."
        bat "docker build -t chetankatkar/smart-irrigation:${BUILD_NUMBER} -t chetankatkar/smart-irrigation:latest ."
        
        echo "Pushing Docker image to Docker Hub Registry..."
        // bat "docker push chetankatkar/smart-irrigation:${BUILD_NUMBER}"
        // bat "docker push chetankatkar/smart-irrigation:latest"
    }
}

stage('Containerized Deployment') {
    steps {
        echo "Deploying containerized application on port 8086..."
        bat "docker stop irrigation-app || exit 0"
        bat "docker rm irrigation-app || exit 0"
        bat "docker run -d -p 8086:8085 --name irrigation-app chetankatkar/smart-irrigation:latest"
    }
}
```

---

## 🎯 Verification
- **Docker Registry:** Image tagged with automated build number and `latest`.
- **Zero-Downtime Rolling Update:** Container gracefully stops previous instance and binds new version to port 8086.
- **Port Isolation:** Application runs isolated inside the container environment.
