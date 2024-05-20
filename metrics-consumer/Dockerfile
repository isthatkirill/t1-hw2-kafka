FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /
COPY / /
RUN mvn -f pom.xml clean package --amd -pl metrics-consumer

FROM openjdk:17-jdk-slim
COPY --from=build metrics-consumer/target/*.jar app.jar
COPY --from=build ../.env .env
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]

