FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn --batch-mode --no-transfer-progress -DskipTests package

FROM eclipse-temurin:21-jre-alpine

LABEL maintainer="Chetan Katkar <23102A0024>"
LABEL description="Smart Irrigation Alert Dashboard - DevOps Container"

WORKDIR /app
COPY --from=build /workspace/target/smart-irrigation-dashboard.jar app.jar

EXPOSE 8085
USER 10001:10001
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
