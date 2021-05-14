FROM openjdk:8-jdk-alpine
WORKDIR /usr/local/bin
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]
