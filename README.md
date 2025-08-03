# Gestion-des-taches
#  Application de Gestion des Tâches

Cette application est une API REST développée avec **Spring Boot**, permettant de créer, consulter, modifier et supprimer des tâches. Chaque tâche a un titre, une description, un responsable, une date de création, une échéance, un statut et une priorité.

##  Fonctionnalités

-  Créer une nouvelle tâche
-  Récupérer toutes les tâches
-  Récupérer une tâche par ID
-  Filtrer les tâches par statut (`A_FAIRE`, `EN_COURS`, `TERMINEE`)
-  Modifier une tâche existante
-  Supprimer une tâche
-  Vérification automatique des doublons (titre + description)


##  Technologies utilisées

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- MapStruct
- Lombok
- Swagger (OpenAPI 3)

## Lancer le projet

### 1. Cloner le dépôt
bash
git clone https://github.com/ton-utilisateur/gestion-des-taches.git
cd gestion-des-taches

### 2. Configurer la base de données

Dans application.properties
- spring.datasource.url=jdbc:postgresql://localhost:5432/ma_base
- spring.datasource.username=postgres
- spring.datasource.password=mot_de_passe
- spring.jpa.hibernate.ddl-auto=update
**Remplacez les valeurs selon vos configuration PostgreSQL.

3. Démarrer l'application
--> sous windows: mvn spring-boot:run
   
 Points d'entrée de l'API (Endpoints)
--> URL : http://localhost:8080/api/taches
## http://localhost:8080/swagger-ui/index.html

## creation d'une tache: 
## http://localhost:8080/swagger-ui/index.html#/tache-controller/creerTache
{
  "titre": "Préparer la présentation",
  "description": "Créer les slides pour la présentation client de la semaine prochaine.",
  "statut": "EN_COURS",
  "priorite": "MOYENNE",
  "responsable": "Alice",
  "dateEcheance": "2025-04-17"
}
## voir toute les taches
## http://localhost:8080/swagger-ui/index.html#/tache-controller/lireToutesLesTaches
[
  {
    "titre": "Préparer la documentation utilisateur",
    "description": "Créer un guide complet d'utilisation de l'application",
    "statut": "EN_COURS",
    "priorite": "HAUTE",
    "responsable": "Bob",
    "dateEcheance": "2025-05-15"
  },
  {
    "titre": "Mise à jour de la base de données",
    "description": "Ajout de nouvelles colonnes pour le suivi des statuts",
    "statut": "TERMINEE",
    "priorite": "MOYENNE",
    "responsable": "Claire",
    "dateEcheance": "2025-05-10"
  },
  {
    "titre": "Nettoyage du code",
    "description": "Refactorisation des services et suppression du code mort",
    "statut": "EN_COURS",
    "priorite": "MOYENNE",
    "responsable": "David",
    "dateEcheance": "2025-05-15"
  },
  {
    "titre": "Revue hebdomadaire",
    "description": "Évaluer l'avancement des tâches chaque vendredi",
    "statut": "A_FAIRE",
    "priorite": "HAUTE",
    "responsable": "Emma",
    "dateEcheance": "2025-04-19"
  },
  {
    "titre": "Apprende spring boot",
    "description": "Maîtriser les conceptes fondamentaux",
    "statut": "EN_COURS",
    "priorite": "MOYENNE",
    "responsable": "Jean",
    "dateEcheance": "2025-05-30"
  },
  {
    "titre": "Préparer la présentation",
    "description": "Créer les slides pour la présentation client de la semaine prochaine.",
    "statut": "EN_COURS",
    "priorite": "MOYENNE",
    "responsable": "Alice",
    "dateEcheance": "2025-04-17"
  }
## voir taches par leur statut
## http://localhost:8080/api/taches/statut/EN_COURS
  {
    "titre": "Apprende spring boot",
    "description": "Maîtriser les conceptes fondamentaux",
    "statut": "EN_COURS",
    "priorite": "MOYENNE",
    "responsable": "Jean",
    "dateEcheance": "2025-05-30"
  },
  {
    "titre": "Préparer la présentation",
    "description": "Créer les slides pour la présentation client de la semaine prochaine.",
    "statut": "EN_COURS",
    "priorite": "MOYENNE",
    "responsable": "Alice",
    "dateEcheance": "2025-04-17"
  }
  
  # modifier une tache (on entre l'id de la tache a modifier:id allant de 11 a 16)
  # http://localhost:8080/api/taches/16
   {
  "titre": "Préparer la présentation",
  "description": "Créer les slides pour la présentation client de la semaine prochaine.",
  "statut": "EN_COURS",
  "priorite": "HAUTE",
  "responsable": "Alice",
  "dateEcheance": "2025-04-17"
}

# lire tache par id(allant de 11 a 16)
# http://localhost:8080/api/taches/15
{
  "titre": "Revue hebdomadaire",
  "description": "Évaluer l'avancement des tâches chaque vendredi",
  "statut": "A_FAIRE",
  "priorite": "HAUTE",
  "responsable": "Emma",
  "dateEcheance": "2025-04-19"
}
