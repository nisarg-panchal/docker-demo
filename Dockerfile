FROM openjdk:21-ea-18-jdk-oraclelinux8

COPY target/docker-demo-0.0.1-SNAPSHOT.jar application.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "application.jar"]