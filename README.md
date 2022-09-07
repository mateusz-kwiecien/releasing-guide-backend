# Releasing Guide Backend

---

## Basic Info 

This repository will contain backend park of Releasing Guide application.
I'm going to use Java 17, Spring Boot 2, Spring Framework 5, Spock and Mongodb.

The main purpose of this project is to provide simple and intuitive application
for releasing documentation for microservices (necessary releasing info, scripts, changes etc.)
and any other utils for maintain releasing process.

This is the first part, second will be frontend application, where I plan to use React (mainly for
learning purposes)

As the whole project, this readme file also will be developed and filled with necessary info.

---

### Run as Docker container

First build an image being in a root folder where the Dockerfile is:

> docker image build -t releasing-guide .

Then run container, providing basic MongoDB properties:

> docker run -e MONGO_DB_HOST={host} -e MONGO_DB_PORT={port} -e MONGO_DB_USER={username} -e MONGO_DB_PASSWORD={password} releasing-guide
