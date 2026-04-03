FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY target/task-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

# Variables d'environnement par défaut (surchargeables par Kubernetes)
ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/task_manager
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=

ENTRYPOINT ["java", "-jar", "app.jar"]
