# Electron - Tutoriel de base

Ce dossier contient le code du tutoriel de base d'Electron, que je suis pour apprendre les fondamentaux de la création d'applications de bureau multiplateformes avec **Electron**. Electron permet de créer des applications de bureau en utilisant les technologies web comme **JavaScript**, **HTML**, et **CSS**.

## Objectif

Le but de ce projet est de se familiariser avec les bases d'Electron, telles que la création de fenêtres, le chargement de pages HTML, et la gestion des interactions avec l'interface utilisateur. Ce projet suit les étapes du tutoriel officiel d'Electron.

## Prérequis

Pour suivre ce tutoriel, assurez-vous d'avoir **Node.js** et **npm** installés. Vous pouvez vérifier les versions installées en exécutant les commandes suivantes :

```bash
node -v
npm -v
```

Si vous n'avez pas Node.js, téléchargez-le et installez-le depuis nodejs.org.

## Installation
Clonez le dépôt :

```bash
git clone https://github.com/Jeremy-Huleux/ExerciceCDA.git
```

**Accédez au sous-dossier Electron :**

```bash
cd Nom-du-repo/electron
```

**Installez Electron en tant que dépendance de développement :**

```bash
npm install electron --save-dev
```

## Structure du projet

**main.js** : Fichier principal où l'application Electron est initialisée, créant une fenêtre de base et chargeant une page HTML.
**index.html** : Page HTML de base affichée par l'application.
**renderer.js** : Fichier JavaScript côté client qui gère les interactions avec l'interface utilisateur.


## Lancer l'application

Pour démarrer l'application Electron, exécutez la commande suivante :

```bash
npx electron .
```

ou 

```bash
npm run electron
```
(Main modifié)

Cela ouvre une fenêtre affichant index.html, et initialise le fichier main.js comme point d'entrée de l'application.

## Fonctionnalités couvertes dans ce tutoriel

**Ce tutoriel couvre les bases d'Electron, incluant :**

La création d'une fenêtre d'application avec BrowserWindow.
Le chargement et l'affichage d'une page HTML.
La communication entre le processus principal (back-end) et le processus de rendu (front-end) si nécessaire.
Pour plus d'informations, consultez le tutoriel officiel d'Electron.





