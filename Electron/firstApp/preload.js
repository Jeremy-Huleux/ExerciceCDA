
const { contextBridge, ipcRenderer } = require('electron')


// Expose un objet 'version' avec une 
// fonction pour recup la version du node, chrome et electron.
contextBridge.exposeInMainWorld('versions', {
  node: () => process.versions.node,
  chrome: () => process.versions.chrome,
  electron: () => process.versions.electron,
  //ping: () => ipcRenderer.invoke('ping')
  //Nous pouvons exposer des variables en plus des fonctions
})

// Expose un autre objet 'electron' avec une fonction différente
contextBridge.exposeInMainWorld('electronApp', {
  getData: () => ipcRenderer.invoke('get-data')// Cette fonction envoie la requête 'get-data' au Main process
})