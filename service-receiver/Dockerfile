FROM openjdk:11.0.7-jre-slim
RUN mkdir /app
WORKDIR /app
COPY target/service-receiver-0.0.1-SNAPSHOT.jar /app
EXPOSE 8087
CMD ["--spring.profiles.active=gcp"]
ENTRYPOINT ["java", "-jar", "service-receiver-0.0.1-SNAPSHOT.jar"]