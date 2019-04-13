FROM openjdk:8
ADD target/payment-service.jar payment-service.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "payment-service.jar"]