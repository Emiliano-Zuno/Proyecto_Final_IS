FROM amazoncorretto:24.0.1-alpine3.21
LABEL authors="emiliano"
WORKDIR /app
COPY ./videojuegoapi/target/videojuegoapi-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "./app.jar"]