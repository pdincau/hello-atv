FROM openjdk:8-jre-alpine

RUN mkdir /app

COPY target/hello-atv-jar-with-dependencies.jar /app/main.jar

WORKDIR /app

CMD ["java", "-jar", "main.jar"]