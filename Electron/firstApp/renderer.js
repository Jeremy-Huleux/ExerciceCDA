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
  const infoElement = document.getElementById('info');
  infoElement.innerText = message; // affiche le message pour l'utilisateur
}

const handleClick = () => {
  displayMessage('Chargement des données');
  getDataFromMain();
};

document.getElementById('getDataButton').addEventListener('click', handleClick);

information.innerText = `Cette application utilise Chrome (v${versions.chrome()}), Node.js (v${versions.node()}), et Electron (v${versions.electron()})`
