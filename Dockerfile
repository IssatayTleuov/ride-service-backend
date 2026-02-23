FROM maven:3.8.5-eclipse-temurin-17 AS maven-build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

# the base image
FROM amazoncorretto:17
LABEL authors="issataytleuov"

COPY --from=maven-build /app/target/*.jar /application.jar

# Set the default command to run the Java application
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]
