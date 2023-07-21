FROM amazoncorretto:20-alpine3.15-jdk
LABEL authors="vasiliy"
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]