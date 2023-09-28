FROM --platform=linux/amd64 amazoncorretto:17-alpine-jdk
EXPOSE 8081
ADD target/spring-boot-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]