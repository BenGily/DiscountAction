FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY build/libs/discountProj-0.0.1-SNAPSHOT.jar /app/spring-boot-application.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]