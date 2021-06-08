FROM openjdk:11.0.7-jre-slim
RUN mkdir /app
WORKDIR /app
COPY target/api-gatewayy-0.0.1-SNAPSHOT.jar /app
EXPOSE 8085
CMD ["--spring.profiles.active=gcp"]
ENTRYPOINT ["java", "-jar", "api-gatewayy-0.0.1-SNAPSHOT.jar"]