FROM docker.io/library/openjdk:17-jdk-slim
WORKDIR /app
COPY ./target/scheduler-0.0.1-SNAPSHOT.jar /app/scheduler-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/scheduler-0.0.1-SNAPSHOT.jar"]