# Imagen base para el backend (puedes cambiarla según tus necesidades)
FROM openjdk:11 as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN sh mvnw install -DskipTests

EXPOSE 8080
CMD ["java", "-jar", "target/foodtrack-0.0.1-SNAPSHOT.jar"]
