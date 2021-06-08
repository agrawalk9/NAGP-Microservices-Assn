FROM openjdk:11.0.7-jre-slim
RUN mkdir /app
WORKDIR /app
COPY target/admin-team-0.0.1-SNAPSHOT.jar /app
EXPOSE 8085
CMD ["--spring.profiles.active=gcp"]
ENTRYPOINT ["java", "-jar", "admin-team-0.0.1-SNAPSHOT.jar"]