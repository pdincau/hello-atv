FROM openjdk:8-jre-alpine

WORKDIR /app

COPY target/hello-atv-jar-with-dependencies.jar ./app.jar

CMD ["java", "-jar", "app.jar"]