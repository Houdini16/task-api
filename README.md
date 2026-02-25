# Task API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![Docker](https://img.shields.io/badge/Docker-blue)

API REST pour la gestion des tâches, développée dans le cadre du projet DevOps L3 ISI.

## 📋 Description

`task-api` est le module REST de la plateforme de gestion de tâches. Il expose les endpoints HTTP et utilise le module `task-core` pour la logique métier.

## 🔧 Prérequis

- **Java 17**
- **Maven 3.x**
- **Docker** (pour la containerisation)
- **Nexus Repository** (accès à `task-core:0.3.0`)

## 📁 Structure du projet

```
task-api/
├── src/main/java/sn/isi/l3gl/api/task/
│   ├── TaskController.java     # REST Controller
│   └── TaskApiApplication.java # Point d'entrée Spring Boot
├── src/main/resources/
│   └── application.properties
├── Dockerfile                  # Containerisation
└── pom.xml
```

## 🌐 Endpoints API

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| `POST` | `/api/tasks` | Créer une nouvelle tâche |
| `GET` | `/api/tasks` | Lister toutes les tâches |
| `PUT` | `/api/tasks/{id}/status` | Modifier le statut d'une tâche |
| `GET` | `/api/tasks/done/count` | Nombre de tâches terminées (DONE) |

### Exemples d'utilisation

```bash
# Créer une tâche
curl -X POST http://localhost:8085/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Ma tâche","description":"Description"}'

# Lister les tâches
curl http://localhost:8085/api/tasks

# Modifier le statut
curl -X PUT "http://localhost:8085/api/tasks/1/status?status=DONE"

# Compter les tâches terminées
curl http://localhost:8085/api/tasks/done/count
```

## 🚀 Installation

### 1. Build

```bash
mvn clean install
```

### 2. Exécution locale

```bash
java -jar target/task-api-0.0.1-SNAPSHOT.jar
```

L'API sera accessible sur `http://localhost:8085`.

## 🐳 Docker

### Build de l'image

```bash
docker build -t houdini16/task-api:latest .
```

### Push sur Docker Hub

```bash
docker push houdini16/task-api:latest
```

### Exécution avec Docker

```bash
docker run -p 8085:8085 houdini16/task-api:latest
```

## 📦 Dépendance Nexus

`task-api` dépend de `task-core:0.3.0` publié sur Nexus.

Configuration dans `pom.xml` :
```xml
<repositories>
    <repository>
        <id>nexus-releases</id>
        <url>http://localhost:8081/repository/maven-releases/</url>
    </repository>
</repositories>
```

## ⚙️ Configuration Maven

Fichier `~/.m2/settings.xml` requis pour accéder à Nexus :

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 
                              https://maven.apache.org/xsd/settings-1.0.0.xsd">
  <servers>
    <server>
      <id>nexus-releases</id>
      <username>admin</username>
      <password>VOTRE_MOT_DE_PASSE</password>
    </server>
  </servers>
</settings>
```

## 🔗 Liens

- **GroupId**: `sn.isi.l3gl.api`
- **ArtifactId**: `task-api`
- **Port**: `8085`
- **Dépendance**: `task-core:0.3.0`
- **Docker Hub**: `houdini16/task-api:latest`

## 👥 Auteurs

- **Abdoulaye Bilal S. Diop** - [GitHub](https://github.com/Houdini16)
- **Madieye Anne** - [GitHub](https://github.com/Madieyeee)

**Date**: Février 2026
