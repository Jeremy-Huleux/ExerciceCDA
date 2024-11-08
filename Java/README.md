# Gestion d'Entreprise - Projet Java

Ce projet Java est un exercice de création d'une application de gestion d'entreprise, intégrant divers concepts de **programmation orientée objet**, **JavaFX** pour l'interface graphique, et des techniques avancées de Java comme les opérateurs ternaires imbriqués et le design pattern **Factory**.

## Objectif

L'objectif principal de ce projet est d'explorer différentes facettes de Java à travers la création d'une application qui gère les informations d'une entreprise et de ses employés, en utilisant des techniques de programmation avancées et une interface utilisateur basique avec **JavaFX**.

## Fonctionnalités du Projet

L'application inclut les fonctionnalités suivantes :

- **Gestion des employés** : Ajout, suppression, et affichage d'employés, avec des détails tels que le nombre d'enfants, certaines dates importantes, le poste, et le directeur associé.
- **Interface JavaFX** : Utilisation de **JavaFX** pour concevoir une interface graphique simple permettant l'interaction avec les données des employés.
- **Opérateurs ternaires imbriqués** : Utilisés pour traiter certaines logiques décisionnelles complexes dans le code, optimisant ainsi certaines conditions.
- **Factory Pattern pour les employés** : Implémentation d'un pattern **Factory** pour créer des employés aléatoires avec des attributs prédéfinis (fonctionnalité en cours de développement).

## Structure du Projet

- **src/** : Contient les fichiers sources Java.
    - **Main.java** : Point d'entrée de l'application.
    - **Model/Employe.java** : Classe représentant un employé, avec des attributs comme le nom, l'âge, le nombre d'enfants, etc.
    - **Model/Entreprise.java** : Classe pour gérer les informations globales de l'entreprise.
    - **Model/Enfant.java** : Classe pour gérer les informations sur les enfants de chaque employé.
    - **Model/Agence.java** : Classe pour gérer les agences de l'entreprise.
    - **Model/Directeur.java** : Classe pour gérer les informations sur le directeur ainsi que sa prime spécifique.
- **demo/src/main/java/org/example/rh/HelloApplication.java** : Classe contenant le code pour l'interface utilisateur JavaFX.
- **resources/** : Contient les fichiers nécessaires à l'interface JavaFX.

## Installation

1. Clonez le dépôt :

    ```bash
    git clone https://github.com/Jeremy-Huleux/ExerciceCDA.git
    ```

2. Accédez au dossier du projet Java :

    ```bash
    cd ExerciceCDA/Java
    ```

3. Compilez et lancez le projet dans votre environnement Java IDE ou avec les commandes suivantes :

    ```bash
    javac -d bin src/*.java
    java -cp bin Main
    ```

## Lancement de l'interface JavaFX

Pour lancer l'interface JavaFX, exécutez la classe `JavaFXApp` en spécifiant le fichier FXML si nécessaire, afin de visualiser l'interface de gestion des employés.

## Fonctionnalités futures

Ce projet est en développement actif. Les fonctionnalités envisagées comprennent :

- **Amélioration de la Factory d'employés** pour générer automatiquement des employés aux caractéristiques variées.
- **Ajout de fonctionnalités JavaFX avancées** : Dialogues, notifications, et mises à jour en temps réel pour une meilleure expérience utilisateur.

## Ressources

Ce projet suit les bases du développement Java et utilise **JavaFX** pour l'interface. Pour en savoir plus sur les technologies utilisées :
- [Documentation Java](https://docs.oracle.com/en/java/)
- [Guide JavaFX](https://openjfx.io/)

N'hésitez pas à explorer le code et à me faire part de toute suggestion d'amélioration !
