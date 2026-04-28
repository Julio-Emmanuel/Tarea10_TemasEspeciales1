FROM eclipse-temurin:17-jdk
LABEL authors="Julio"
WORKDIR /app
COPY target/*.jar app.jar
ENV DEMO=algo

ENTRYPOINT ["java", "-jar","app.jar"]