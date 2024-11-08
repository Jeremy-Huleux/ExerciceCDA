const { app, BrowserWindow, ipcMain } = require("electron/main");
const path = require("node:path");
const { callbackify } = require("node:util");


const createWindow = () => {
  const win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      preload: path.join(__dirname, "preload.js"),
    },
  });
  win.loadFile("index.html");
};

// Défini le gestionnaire de l'IPC avant de créer la fenêtre ou dans le bloc whenReady
// Gestionnaire de l'IPC pour recevoir une requête depuis le Renderer
ipcMain.handle('get-data', () => {
  return "Données envoyées depuis le Main process";  // Ceci est la réponse que j'envoies au Renderer 
});


app.whenReady().then(() => {
  // Crée la fenêtre lorsque l'application est prête
  createWindow();

  // Gère la demande de l'heure
  ipcMain.handle("request-time", () =>{
    const currentTime = new Date().toLocaleTimeString();
    return currentTime;
  })
  // On peut également ajouter d'autres écouteurs d'événements ici si nécessaire
  app.on("activate", () => {
    if (BrowserWindow.getAllWindows().length === 0) createWindow();
  });
});

app.on("window-all-closed", () => {
  if (process.platform !== "darwin") app.quit();
});
