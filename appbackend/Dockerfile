FROM openjdk:11
ADD target/app.jar appbackend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "appbackend.jar"]