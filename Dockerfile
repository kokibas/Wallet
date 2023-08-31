FROM openjdk:17
COPY target/*.jar wallet.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","wallet.jar"]