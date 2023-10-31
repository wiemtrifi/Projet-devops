FROM openjdk:1.8

# Expose the port on which the Java application will listen.
EXPOSE 8080

# Add the JAR file from your local machine to the Docker image.
# Make sure the JAR file is in the same directory as this Dockerfile.
ADD target/timesheet-devops-1.0.jar timesheet-devops-1.0.jar

# Define the command to run when the Docker container starts.
ENTRYPOINT ["java", "-jar", "/achat-devops-1.0.jar"]