FROM openjdk:11.0.7-jre-slim
RUN mkdir /app
WORKDIR /app
COPY target/service-provider-0.0.1-SNAPSHOT.jar /app
EXPOSE 8086
CMD ["--spring.profiles.active=gcp"]
ENTRYPOINT ["java", "-jar", "service-provider-0.0.1-SNAPSHOT.jar"]