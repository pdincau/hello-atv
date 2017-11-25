FROM openjdk:8-jre-alpine

WORKDIR /app

COPY target/hello-atv-jar-with-dependencies.jar ./app.jar

RUN ["java", "-jar", "app.jar"]