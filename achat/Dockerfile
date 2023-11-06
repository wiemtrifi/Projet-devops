FROM openjdk:11

# Set the Nexus URL and the artifact path
ARG NEXUS_URL=http://172.18.0.1:8081/service/rest/repository/browse/maven-releases
ARG ARTIFACT_PATH=tn/esprit/rh/achat/1.0/

# Create a directory to store the downloaded JAR
RUN mkdir /devopsproject

# Download the JAR from Nexus and copy it into the container
RUN wget -O /devopsproject/achat-1.0.jar $NEXUS_URL/$ARTIFACT_PATH

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/devopsproject/achat-1.0.jar"]