# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="vivek.dubeymca@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8888 available to the world outside this container
EXPOSE 8084

# The application's jar file
ARG JAR_FILE=target/student-consumer-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} student-consumer.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/student-consumer.jar"]