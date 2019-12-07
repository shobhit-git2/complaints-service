FROM openjdk:8-jre-alpine

USER root

ADD ./target/*.jar /opt/complaints-service-2.2.1.RELEASE.jar
CMD ["java", "-Xmx200m", "-jar", "/opt/complaints-service-2.2.1.RELEASE.jar"]
