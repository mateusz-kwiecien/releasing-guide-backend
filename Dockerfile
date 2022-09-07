FROM openjdk:17.0.2-slim-buster

COPY ./build/libs/releasing-guide.jar .

ENTRYPOINT java -jar releasing-guide.jar

EXPOSE 8080