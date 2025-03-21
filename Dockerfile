FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /hello-db-service

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk

WORKDIR /helloService


COPY --from=builder /hello-db-service/target/*.jar helloDbService.jar

EXPOSE 8088

CMD [ "java", "-jar", "helloDbService.jar"]