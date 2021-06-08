FROM openjdk:11.0.7-jre-slim
RUN mkdir /app
WORKDIR /app
COPY target/order-service-0.0.1-SNAPSHOT.jar /app
EXPOSE 8088
CMD ["--spring.profiles.active=gcp"]
ENTRYPOINT ["java", "-jar", "order-service-0.0.1-SNAPSHOT.jar"]