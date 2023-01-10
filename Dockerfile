FROM adoptopenjdk/openjdk11:latest
LABEL maintainer="alberto.pedraza@elektra.com.mx"
ENV TZ=America/Mexico_City

ENV ibrahim_name="alberto ibrahim pedraza casasola from docker env"

WORKDIR /opt

COPY target/task-service-huellas-0.0.1-SNAPSHOT.jar /opt/task-service-huellas-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar", "/opt/task-service-huellas-0.0.1-SNAPSHOT.jar"]