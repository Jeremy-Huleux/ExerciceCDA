package org.example.rh.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import javax.management.Notification;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        Button button = new Button("Ajouter");
        Button button2 = new Button("Modifier");
        Button button3 = new Button("Supprimer");
        HBox menuTop = new HBox(80);
        menuTop.setPadding(new Insets(10));
        menuTop.setAlignment(Pos.TOP_CENTER);
        menuTop.getChildren().addAll(button, button2, button3);
        StackPane root = new StackPane();
        root.getChildren().add(menuTop);
        button.setOnAction(e -> ajoutFonction());
        button2.setOnAction(e -> modifierFonction());
        button3.setOnAction(e -> suppressionFonction());

        Scene scene = new Scene(root, 800, 800);
        stage.setTitle("Test scene");
        stage.setScene(scene);
        stage.show();
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