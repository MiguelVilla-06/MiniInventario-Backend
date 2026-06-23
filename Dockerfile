FROM eclipse-temurin:25-jdk-alpine
LABEL author="Leandro Enrique Silva Lejarazo"
ARG JAR_FILE=target/MiniInventario-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} MiniInventario.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","MiniInventario.jar"]