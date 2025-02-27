FROM openjdk:21-slim

WORKDIR /usr/src/app

COPY target/stumgt-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
