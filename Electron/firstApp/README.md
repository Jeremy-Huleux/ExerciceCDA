# Architecture du code 

## Apprentissage de l'utilisation d'Electron

-package **OK**
-main **OK**
-Preload **OK**
-Renderer **OK**
-index **OK**

## En cours ...

**Tester l'architecture comme ceci** : 

/firstApp
├── /back                # Logique du Main process et communication avec le système
│   ├── main.js          # Le fichier principal qui démarre l'application
│   ├── ipcHandlers.js   # Gestion des appels IPC dans le Main process
│   ├── /services        # Fichiers liés à des services ou à la gestion des données
│   └── /utils           # Utilitaires, fonctions réutilisables du back-end
│
├── /front               # Code du Renderer process (interface utilisateur)
│   ├── index.html       # Fichier HTML principal pour l'interface
│   ├── /assets          # Images, icônes, fichiers CSS, etc.
│   ├── /js              # Scripts JavaScript pour l'UI
│   │   ├── renderer.js  # Fichier principal du Renderer process
│   │   ├── functions.js # Fonctions réutilisables pour l'UI
│   │   └── api.js       # API pour l'interaction avec le Main process
│   └── /styles          # Fichiers CSS ou SCSS pour le style de l'UI
│
├── /public              # Fichiers publics comme des images ou des polices
├── package.json         # Dépendances et configuration du projet
└── /node_modules        # Modules Node.js installés
