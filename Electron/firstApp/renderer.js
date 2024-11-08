const information = document.getElementById('info')

//Fonction qui appelle le main process pour obtenir des données
const getDataFromMain = async () => {
  try{
    const reponse = await window.electronApp.getData();
    console.log("Données du main process:", reponse); // affiche la rep du main
  } catch (error){
    console.error("Erreur lors de l'obtention des données :", error);
  }
}

// Fonction qui affiche un message à l'utilisateur
const displayMessage = (message) => {
  information.innerText = message; // affiche le message pour l'utilisateur
}

const handleClick = () => {
  displayMessage('Chargement des données');
  getDataFromMain();
};

//Fonction qui affiche l'heure
const afficheHeure = async () => {
  try{
    information.innerText =  `Heure actuelle : ${await electronApp.getTime()}`; 
  } catch (error) {
    console.error("Erreur lors de la recupération du l'heure system : ", error);
  }
}


document.getElementById('getDataButton').addEventListener('click', handleClick);
document.getElementById('getTime').addEventListener('click', afficheHeure);

information.innerText = `Cette application utilise Chrome (v${versions.chrome()}), Node.js (v${versions.node()}), et Electron (v${versions.electron()})`
