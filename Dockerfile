FROM ghcr.io/graalvm/graalvm-community:25 AS build

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "target/MiniInventario-0.0.1-SNAPSHOT.jar"]