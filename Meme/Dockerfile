# Definindo a imagem base
FROM openjdk:23-jdk-slim

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o JAR gerado para dentro do container
COPY target/*.jar app.jar

# Definindo a variável de ambiente para desabilitar os logs de debug do Spring Boot
ENV SPRING_PROFILES_ACTIVE=prod

# Expondo a porta em que o serviço vai rodar
EXPOSE 8082

# Comando para rodar o aplicativo no container
ENTRYPOINT ["java", "-jar", "app.jar"]
