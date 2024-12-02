package org.example.rh.demo.Erreurs;

import javafx.scene.control.Alert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionnaireErreur {

    private static final Logger logger = Logger.getLogger(GestionnaireErreur.class.getName());


    //Methode pour afficher popup d'erreur synthaxique
    public static void afficherErreurSynthaxique(String message, Throwable cause){
        logger.log(Level.SEVERE, message, cause); //log d'erreur
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de syntaxe : iso 8");
        alert.setContentText(message);
        alert.showAndWait();
    }

}
