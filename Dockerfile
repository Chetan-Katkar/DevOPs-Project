# Multi-stage / Lightweight JRE base image for Java 21
FROM eclipse-temurin:21-jre-alpine

LABEL maintainer="Chetan Katkar <23102A0024>"
LABEL description="Smart Irrigation Alert Dashboard - DevOps Container"

WORKDIR /app

# Copy the built Spring Boot fat JAR into the container
COPY target/smart-irrigation-dashboard.jar app.jar

# Expose internal application port
EXPOSE 8085

# Run the standalone Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
