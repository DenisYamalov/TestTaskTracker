FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} TaskTracker-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/TaskTracker-1.0-SNAPSHOT.jar"]