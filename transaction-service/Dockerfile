FROM gradle:7.5.1-jdk17 as build
WORKDIR /workspace/app

COPY ./gradle gradle
COPY transaction-service ./
COPY gradle.properties ./

RUN gradle build -x test

FROM eclipse-temurin:17
VOLUME /tmp
EXPOSE 8083
ARG DEPENDENCY=/workspace/app/build/libs
COPY --from=build ${DEPENDENCY}/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","app/app.jar"]