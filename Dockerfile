FROM maven:3.9.8-eclipse-temurin-21 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM   eclipse-temurin:21-jre

COPY --from=builder /app/target/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar

EXPOSE 9000

CMD ["java", "-jar", "/app/api-gateway.jar"]
