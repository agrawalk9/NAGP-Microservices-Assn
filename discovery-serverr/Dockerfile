FROM openjdk:11.0.7-jre-slim
RUN mkdir /app
WORKDIR /app
COPY target/discovery-serverr-0.0.1-SNAPSHOT.jar /app
EXPOSE 8761
CMD ["--spring.profiles.active=gcp"]
ENTRYPOINT ["java", "-jar", "discovery-serverr-0.0.1-SNAPSHOT.jar"]