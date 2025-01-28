# Base de données Dockerisée - Tests et Exercices

Bienvenue dans ce dépôt ! Ce projet contient mes tests et exercices personnels visant à apprendre à containeriser une base de données de manière sécurisée avec Docker.

## 📚 Objectif du Dépôt

L'objectif de ce dépôt est d'explorer et de pratiquer différentes techniques pour configurer et déployer une base de données dans un conteneur Docker en toute sécurité. Cela inclut :

- La mise en place de conteneurs de base de données sécurisés.
- La configuration de l'authentification et des rôles utilisateurs.
- La gestion sécurisée des variables d'environnement.
- L'application de restrictions réseau et de pare-feu pour les conteneurs.
- Les tests de processus de sauvegarde et de restauration pour garantir l'intégrité des données.

## 🚀 Technologies Utilisées

- **Docker** : Pour la containerisation de la base de données.
- **Bases de données** : Focus sur les bases relationnelles comme MySQL, PostgreSQL ou similaires.
- **Docker Compose** : Pour simplifier les configurations multi-conteneurs (si nécessaire).
- **Outils de Sécurité** : Gestion des variables d'environnement, gestion des utilisateurs et configuration réseau sécurisée.

## 🔒 Fonctionnalités de Sécurité Implémentées

Ce dépôt comprend des exemples et des tests pour :

- Protéger l'accès à la base de données avec des utilisateurs et des mots de passe sécurisés.
- Utiliser des variables d'environnement pour éviter l'exposition des informations sensibles.
- Restreindre l'accès réseau avec des configurations spécifiques (ports, réseaux privés Docker, etc.).
- Sauvegarder et restaurer les données en toute sécurité.

## 📂 Structure du Dépôt

└── sakila-db/ # Exemple de configuration Docker Compose en Postregres et Mysql (Fournis par https://github.com/ludovic-esperce)
  ├── MysQL/ # Ensemble de fichier pour créer la BDD MySQL pour l'initialisation et la gestion de la BDD
  ├── PostgreSQL/ # Ensemble de fichier pour créer la BDD Postgres pour l'initialisation et la gestion de la BDD
  └──sakila.svg # Image de présentation de la BDD
