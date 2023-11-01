FROM openjdk:11

# Set the Nexus URL and the artifact path
ARG NEXUS_URL=http://192.168.1.8:8081/repository/maven-releases
ARG ARTIFACT_PATH=tn/esprit/rh/achat/1.0/achat-1.0.jar

# Create a directory to store the downloaded JAR
RUN mkdir /app

# Download the JAR from Nexus and copy it into the container
RUN wget -O /app/achat-1.0.jar $NEXUS_URL/$ARTIFACT_PATH

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/achat-1.0.jar"]