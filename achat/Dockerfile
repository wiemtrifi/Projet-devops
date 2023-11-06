FROM openjdk:11

# Expose the port on which the Java application will listen.
EXPOSE 8082

# Add the JAR file from your local machine to the Docker image.
# Make sure the JAR file is in the same directory as this Dockerfile.
ADD target/devopsproject-1.0.jar devopsproject-1.0.jar

# Define the command to run when the Docker container starts.
ENTRYPOINT ["java", "-jar", "/devopsproject-1.0.jar"]