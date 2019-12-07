FROM openjdk:8-jre-alpine

USER root

ADD ./target/*.jar /opt/complaints-service-1.0.jar
CMD ["java", "-Xmx200m", "-jar", "/opt/complaints-service-1.0.jar"]