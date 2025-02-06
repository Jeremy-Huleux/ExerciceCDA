# Dossier "assets"

Le dossier "assets" a pour objectif de stockers tous les éléments qui sont importés par les composants.

Par exemple, si un composant utilise une image en l'important avec le code suivant :
```js
import exampleImg from "../assets/img/example.svg"; // import d'un SVG

// ... suite du code

// utilisation de l'image
<img src={exampleImg} alt="" />

// ... suite du code
```