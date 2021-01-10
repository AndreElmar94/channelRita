FROM openjdk:11

ADD target/*.jar /home/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
