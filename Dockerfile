FROM tomcat:8.5.84-jdk11-temurin-focal

ARG WAR_FILE
ARG CONTEXT

COPY ${WAR_FILE} /usr/local/tomcat/webapps/${CONTEXT}.war