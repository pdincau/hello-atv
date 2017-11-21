# Hello Agile Tour Vienna

Trivial java application to greet people at Agile Tour Vienna.

## How to test

```sh
mvn clean test
```

## How to build

```sh
mvn clean package
```

## How to run

```sh
java -jar -Dhttp.server.port=${PORT} target/hello-atv-jar-with-dependencies.jar
```

Default port is 8080.

## How to create docker image

```sh
docker build -t pdincau/hello-atv
```

## How to run docker image

```sh
docker run --rm=true -it -p 8080:8080 --name hello-atv pdincau/hello-atv
```

## Greeting route

You can check the health of the service by calling:

```sh
curl localhost:${PORT}/hello?yourname
```

## Healthcheck route

You can check the health of the service by calling:

```sh
curl localhost:${PORT}/ping
```
