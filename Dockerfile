FROM maven:3.8.1-openjdk-11 AS build
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app
RUN mvn clean package -DskipTest

FROM  openjdk:11-jre-slim
COPY --from=build /appp/target/graphqludea1-0.0.1-SNAPSHOT.jar /usr/local/lib/graphqludea1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/graphqludea1.jar"]

