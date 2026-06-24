FROM maven:3.9.6-eclipse-temurin-21 AS build

FROM openjdk:25-ea-jdk-slim AS base

FROM maven:3.9.9-amazoncorretto-25 AS builder
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:25-alpine
COPY --from=builder /target/*.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]