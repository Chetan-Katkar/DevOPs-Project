# Docker Container Lifecycle Log & Documentation

**Project:** Smart Irrigation Alert Dashboard  
**Student:** Chetan Katkar | **Roll No:** 23102A0024 | **Class:** BE CMPN-A  

---

## 🐳 1. Build Docker Image
```bash
# Build the application and versioned image
docker build --tag smart-irrigation:v1.0 .
```

---

## 🔍 2. Verify Image
```bash
docker image ls smart-irrigation
```

---

## 🚀 3. Run Container
```bash
docker run -d -p 8086:8085 --name irrigation-app smart-irrigation:v1.0
```
Access the containerized app in browser at:  
👉 `http://localhost:8086`

---

## 📋 4. Container Lifecycle Commands
```bash
# View container logs
docker logs irrigation-app

# Inspect running status
docker ps --filter name=irrigation-app

# Stop container
docker stop irrigation-app

# Restart container
docker start irrigation-app

# Delete container
docker rm -f irrigation-app
```
