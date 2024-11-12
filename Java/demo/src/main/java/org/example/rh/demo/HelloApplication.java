package org.example.rh.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import org.example.rh.demo.DTO.Person;
import org.example.rh.demo.Model.Agence;


import java.io.IOException;


import static org.example.rh.demo.Factory.PersonFactory.createPerson;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

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
        ------------------- MENUTOP -------------------
         */

        //on declare notre menu dans une HBox (Horizontal box)
        HBox menuTop = new HBox(80); // taille 80
        menuTop.setPadding(new Insets(10)); //padding entre les buttons
        menuTop.setAlignment(Pos.TOP_CENTER); // position center haut
        // on ajoute tous les button a notre "menu header"
        menuTop.getChildren().addAll(button, button2, button3);

        /*
        ------------------- TABLEAU -------------------
         */

        //creation du tableau
        TableView<Person> tableau = new TableView();

        //creation des colonnes
        TableColumn<Person, String> nomColonne = new TableColumn<>("Nom");
        TableColumn<Person, String> prenameColonne = new TableColumn<>("Prenom");
        TableColumn<Person, String> agenceColonne = new TableColumn<>("Agence");
        TableColumn<Person, String> posteColonne = new TableColumn<>("Poste");
        TableColumn<Person, String> serviceColonne = new TableColumn<>("Service");
        TableColumn<Person, String> salaireColonne = new TableColumn<>("Salaire");

        //creation des données manuellement
        Agence agence1 = new Agence("ZaeloTech", true);
        agence1.GenereEmploye(44);

        //creation d'une liste de données
        ObservableList<Person> personnes = FXCollections.observableArrayList(
                createPerson(agence1)
        );

        //creation des lignes de données
        nomColonne.setCellValueFactory(new PropertyValueFactory<>("name"));
        prenameColonne.setCellValueFactory(new PropertyValueFactory<>("prename"));
        agenceColonne.setCellValueFactory(new PropertyValueFactory<>("agence"));
        posteColonne.setCellValueFactory(new PropertyValueFactory<>("poste"));
        serviceColonne.setCellValueFactory(new PropertyValueFactory<>("service"));
        salaireColonne.setCellValueFactory(new PropertyValueFactory<>("salaire"));


        //Ajout des données
        tableau.setItems(personnes);

        //ajuste automatiquement les tailles des colonnes pour faire la taille de l'app
        tableau.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //on ajoute les colonnes au tableau
        tableau.getColumns().addAll(nomColonne, prenameColonne, agenceColonne, posteColonne, serviceColonne, salaireColonne);





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