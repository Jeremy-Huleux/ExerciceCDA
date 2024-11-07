package org.example.rh.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Person person = new Person();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        /*
        ------------------- BUTTONS -------------------
         */

        //creation des button
        Button button = new Button("Ajouter");
        Button button2 = new Button("Modifier");
        Button button3 = new Button("Supprimer");

        //on declare les actions de nos button, ici lance une fonction créer en dessous
        button.setOnAction(e -> ajoutFonction());
        button2.setOnAction(e -> modifierFonction());
        button3.setOnAction(e -> suppressionFonction());

        /*
        ------------------- TABLEAU -------------------
         */

        //creation du tableau
        TableView tableau = new TableView();

        //creation des colonnes
        TableColumn<String, String> colonne1 = new TableColumn<>("Nom");
        TableColumn<String, String> colonne2 = new TableColumn<>("Prenom");
        TableColumn<String, String> colonne3 = new TableColumn<>("Agence");
        TableColumn<String, String> colonne4 = new TableColumn<>("Poste");
        TableColumn<String, String> colonne5 = new TableColumn<>("Service");
        TableColumn<String, String> colonne6 = new TableColumn<>("Salaire");
        //déclaration manuel des tailles de colonnes

        /*
        colonne1.setPrefWidth(133);
        colonne2.setPrefWidth(133);
        colonne3.setPrefWidth(133);
        colonne4.setPrefWidth(133);
        colonne5.setPrefWidth(133);
        colonne6.setPrefWidth(133);
        */
        //ajuste automatiquement les tailles des colonnes pour faire la taille de l'app
        tableau.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //on ajoute les colonnes au tableau
        tableau.getColumns().addAll(colonne1, colonne2, colonne3, colonne4, colonne5, colonne6);



        /*
        ------------------- MENUTOP -------------------
         */

        //on declare notre menu dans une HBox (Horizontal box)
        HBox menuTop = new HBox(80); // taille 80
        menuTop.setPadding(new Insets(10)); //padding entre les buttons
        menuTop.setAlignment(Pos.TOP_CENTER); // position center haut
        // on ajoute tous les button a notre "menu header"
        menuTop.getChildren().addAll(button, button2, button3);


        /*
        ------------------- INSERT ON ROOT -------------------
         */

        VBox root = new VBox(15); // l'affichage principal ou on fourre tout
        //on ajoute notre menu au VBox principal (fourre tout)
        //Utilisation du StackPane pas opti pour l'application changement pour VBox (aligne a la suite verticalement les obj)
        root.getChildren().add(menuTop);
        root.getChildren().add(tableau);

        /*
        ------------------- SCENE -------------------
         */
        //on créer et on affiche la "scene"
        Scene scene = new Scene(root, 800, 800);
        stage.setTitle("Test scene");//titre de la scene
        stage.setScene(scene);//declaration de la scene
        stage.show();//affiche la scene
    }

    private void ajoutFonction(){
        Notifications.create()
                .title("Ajouter")
                .text("C UN AJOUE HEMDEHER")
                .position(Pos.CENTER)
                .showInformation();
    }
    private void modifierFonction(){
        Notifications.create()
                .title("Modifier")
                .text("C UN MODIFIAJE HEMDEHER")
                .position(Pos.CENTER)
                .showInformation();
    }
    private void suppressionFonction(){
        Notifications.create()
                .title("Supprimer")
                .text("C UN SUPREMANT HEMDEHER")
                .position(Pos.CENTER)
                .showInformation();
    }

    public static void main(String[] args) {
        launch();
    }
}