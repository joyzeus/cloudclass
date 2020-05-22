FROM openjdk:11
ADD target/task-1.0.0.jar autosign_task.jar
ENTRYPOINT ["java", "-jar",  "autosign_task.jar"]
EXPOSE 8095