package com.example.jpaentitygenerator;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class MainController {

    @FXML
    private TextField dbUrlField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField outputDirField;

    @FXML
    private TextField packageNameField;

    @FXML
    private TextArea logArea;

    @FXML
    private void handleBrowse() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            outputDirField.setText(selectedDirectory.getAbsolutePath());
        }
    }

    @FXML
    private void handleGenerateEntities() {
        String dbUrl = dbUrlField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String outputDir = outputDirField.getText();
        String packageName = packageNameField.getText();

        if (dbUrl.isEmpty() || username.isEmpty() || password.isEmpty() || outputDir.isEmpty() || packageName.isEmpty()) {
            logArea.appendText("Please fill in all fields.\n");
            return;
        }

        DatabaseConnector connector = new DatabaseConnector(dbUrl, username, password);
        EntityGenerator generator = new EntityGenerator(connector, outputDir, packageName);

        try {
            generator.generateEntities();
            logArea.appendText("Entities generated successfully.\n");
        } catch (Exception e) {
            logArea.appendText("Error generating entities: " + e.getMessage() + "\n");
        }
    }
}

