package org.example.rh.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import org.example.rh.demo.DTO.Person;
import org.example.rh.demo.Factory.PersonFactory;
import org.example.rh.demo.Model.Agence;
import org.example.rh.demo.Model.Employe;
import org.example.rh.demo.Model.Enfant;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


//import static org.example.rh.demo.Factory.PersonsFactory.createPersons;
import static org.example.rh.demo.Factory.PersonFactory.createPerson;

public class HelloApplication extends Application {
    private VBox root = new VBox(15); // l'affichage principal ou on fourre tout
    //creation des données manuellement
    private Agence agence1 = new Agence("ZaeloTech", true);
    //creation du tableauVue
    //Ajout des données
    private TableView<Person> tableauVue = new TableView<>(agence1.personnes);

    // Déclaration des champs comme variables d'instance
    private TextField nameField;
    private TextField prenameField;
    private DatePicker dateField;
    private TextField posteField;
    private ComboBox<String> serviceField;
    private Spinner<Integer> salaireField;
    private String name ;
    private String prename ;
    private LocalDate date ;
    private String poste ;
    private String service ;
    private int salaire ;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        /*
        ------------------- BUTTONS -------------------
         */

        //creation des button
        Button button = new Button("Ajouter");
        Button button0 = new Button("Ajouter un employee aleatoire");
        Button button2 = new Button("Modifier");
        Button button3 = new Button("Supprimer");
        Button button4 = new Button("Supprimer dernier");
        Button button5 = new Button("Supprimer tout");

        //on declare les actions de nos button, ici lance une fonction créer en dessous
        button.setOnAction(e -> ajoutFonction());
        button0.setOnAction(e -> ajoutAelaFonction());
        button2.setOnAction(e -> modifierFonction());
        button3.setOnAction(e -> suppressionFonction());
        button4.setOnAction(e -> suppressionDernierFonction());
        button5.setOnAction(e -> suppressionToutFonction());

        /*

        ------------------- MENUTOP -------------------

         */

        //on declare notre menu dans une HBox (Horizontal box)
        HBox menuTop = new HBox(80); // taille 150
        menuTop.setPadding(new Insets(10)); //padding entre les buttons
        menuTop.setAlignment(Pos.TOP_CENTER); // position center haut
        // on ajoute tous les button a notre "menu header"
        menuTop.getChildren().addAll(button0, button, button2, button3, button4, button5);

        /*
        ------------------- TABLEAU -------------------
         */

        //creation des colonnes
        TableColumn<Person, String> nomColonne = new TableColumn<>("Nom");
        TableColumn<Person, String> prenameColonne = new TableColumn<>("Prenom");
        TableColumn<Person, String> agenceColonne = new TableColumn<>("Agence");
        TableColumn<Person, String> posteColonne = new TableColumn<>("Poste");
        TableColumn<Person, String> serviceColonne = new TableColumn<>("Service");
        TableColumn<Person, String> salaireColonne = new TableColumn<>("Salaire");

        //génération des données
        agence1.GenereEmploye(10);

        //creation des lignes de données
        nomColonne.setCellValueFactory(new PropertyValueFactory<>("name"));
        prenameColonne.setCellValueFactory(new PropertyValueFactory<>("prename"));
        agenceColonne.setCellValueFactory(new PropertyValueFactory<>("agence"));
        posteColonne.setCellValueFactory(new PropertyValueFactory<>("poste"));
        serviceColonne.setCellValueFactory(new PropertyValueFactory<>("service"));
        salaireColonne.setCellValueFactory(new PropertyValueFactory<>("salaire"));

        //ajuste automatiquement les tailles des colonnes pour faire la taille de l'app
        tableauVue.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //on ajoute les colonnes au tableauVue
        tableauVue.getColumns().addAll(nomColonne, prenameColonne, agenceColonne, posteColonne, serviceColonne, salaireColonne);

        /*
        ------------------- INSERT ON ROOT -------------------
         */

        //on ajoute notre menu au VBox principal (fourre tout)
        //Utilisation du StackPane pas opti pour l'application changement pour VBox (aligne a la suite verticalement les obj)
        root.getChildren().add(menuTop);
        root.getChildren().add(tableauVue);

        /*
        ------------------- SCENE -------------------
         */
        //on créer et on affiche la "scene"
        Scene scene = new Scene(root, 1200, 800);
        stage.setTitle("Application Ressources Humaines");//titre de la scene
        stage.setScene(scene);//declaration de la scene
        stage.show();//affiche la scene
    }

    private void ajoutFonction(){
        // Creation des champs textes (input type text)
        /*

         public Employe(String nom, String prenom, String date, String poste, int salaire, String service, ArrayList<Enfant> enfants) {//arraylist enfant nullable

         */

        TextField nameField = new TextField();
        nameField.setPromptText("Nom");

        TextField prenameField = new TextField();
        prenameField.setPromptText("Prénom");

        DatePicker dateField = new DatePicker();
        dateField.setPromptText("Date d'embauche");

        TextField posteField = new TextField();
        posteField.setPromptText("Poste");

        ComboBox<String> serviceField = new ComboBox<>();
        serviceField.setPromptText("Service");
        serviceField.getItems().addAll(agence1.getServices());
        //0 à 250k max
        Spinner<Integer> salaireField = new Spinner<>(0, 250000, 0);
        salaireField.setEditable(true);//permets la saisie direct
        salaireField.setPromptText("Salaire");

        Button addButton = new Button("Valider");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String prename = prenameField.getText();
            LocalDate date = dateField.getValue();
            String poste = posteField.getText();
            String service = serviceField.getValue();
            int salaire = salaireField.getValue();

            ajouterEmploye(name, prename, date, poste, service, salaire);
        });

        //Mise en page des input type text dans un horizontal box
        HBox input = new HBox(10, nameField, prenameField, dateField, posteField, serviceField, salaireField, addButton);
        input.setPadding(new Insets(10));
        input.setAlignment(Pos.CENTER);
        root.getChildren().add(input);
    }
    private void modifierFonction(){
        //On récupére les données sélectionné
        Person selectedPerson = tableauVue.getSelectionModel().getSelectedItem();


        TextField nameField = new TextField();
        nameField.setPromptText("Nom");
        nameField.setText(selectedPerson.getName());

        TextField prenameField = new TextField();
        prenameField.setPromptText("Prénom");
        prenameField.setText(selectedPerson.getPrename());

        DatePicker dateField = new DatePicker();
        dateField.setPromptText("Date d'embauche");
        dateField.setValue(selectedPerson.getDateEmbauche());


        TextField posteField = new TextField();
        posteField.setPromptText("Poste");
        posteField.setText(selectedPerson.getPoste());

        ComboBox<String> serviceField = new ComboBox<>();
        serviceField.setPromptText("Service");
        serviceField.setValue(selectedPerson.getService());


        serviceField.getItems().addAll(agence1.getServices());

        //0 à 250k max
        Spinner<Integer> salaireField = new Spinner<>(0, 250000, 0);
        salaireField.setEditable(true);//permets la saisie direct
        salaireField.setPromptText("Salaire");
        salaireField.getValueFactory().setValue(selectedPerson.getSalaire());

        Button modifButton = new Button("Valider");
        modifButton.setOnAction(e -> {
            if(selectedPerson != null){
                Employe empSecur = new Employe(
                        selectedPerson.getId(),
                        nameField.getText(),
                        prenameField.getText(),
                        dateField.getValue(),
                        posteField.getText(),
                        salaireField.getValue(),
                        serviceField.getValue());
                agence1.modifEmploye(empSecur);
            }
        });

        //Mise en page des input type text dans un horizontal box
        HBox input = new HBox(10, nameField, prenameField, dateField, posteField, serviceField, salaireField, modifButton);
        input.setPadding(new Insets(10));
        input.setAlignment(Pos.CENTER);
        root.getChildren().add(input);

    }
    private void suppressionFonction(){
        Employe selectedPerson = tableauVue.getSelectionModel().getSelectedItem();
        agence1.supprEmployeSelect(selectedPerson);
        //System.out.println("test");
    }
    private void suppressionDernierFonction(){
        agence1.supprEmploye();
    }
    private void suppressionToutFonction(){
        agence1.personnes.clear();
    }
    private void ajoutAelaFonction(){
        agence1.GenereEmploye(1);
    }
    private void ajouterEmploye(String name1, String prename1, LocalDate date, String poste, String service, int salaire){
        Employe empSecure = new Employe(name1, prename1, date, poste, salaire, service);
        agence1.AjoutEmployee(empSecure);
        root.getChildren().remove(2);
    }

    public static void main(String[] args) {
        launch();
    }
}