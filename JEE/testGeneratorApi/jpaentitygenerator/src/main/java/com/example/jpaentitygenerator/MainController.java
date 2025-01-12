package com.example.jpaentitygenerator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import java.io.File;
import java.util.function.Function;

public class MainController {

    @FXML private TextField dbUrlField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField dbNameField;
    @FXML private TextField outputDirField;
    @FXML private ProgressBar progressBar;
    @FXML private ComboBox<String> dbTypeComboBox;
    @FXML private CheckBox builderAnnotationCheckBox;
    @FXML private ComboBox<String> namingConventionComboBox;

    private DatabaseService databaseService;
    private EntityGenerator entityGenerator;

    @FXML
    public void initialize() {
        databaseService = new DatabaseService();
        entityGenerator = new EntityGenerator();
        dbTypeComboBox.getItems().addAll("MySQL", "PostgreSQL", "Oracle");
        dbTypeComboBox.setValue("MySQL");
        namingConventionComboBox.getItems().addAll("PascalCase", "camelCase", "snake_case");
        namingConventionComboBox.setValue("PascalCase");
    }

    @FXML
    private void testConnection() {
        DatabaseConfig config = new DatabaseConfig(
            dbUrlField.getText(),
            usernameField.getText(),
            passwordField.getText(),
            dbNameField.getText(),
            dbTypeComboBox.getValue()
        );

        if (databaseService.testConnection(config)) {
            showAlert(Alert.AlertType.INFORMATION, "Connection Successful", "Database connection test passed.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Connection Failed", "Unable to connect to the database. Please check your settings.");
        }
    }

    @FXML
    private void browseOutputDir() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            outputDirField.setText(selectedDirectory.getAbsolutePath());
        }
    }

    @FXML
    private void generateEntities() {
        DatabaseConfig dbConfig = new DatabaseConfig(
            dbUrlField.getText(),
            usernameField.getText(),
            passwordField.getText(),
            dbNameField.getText(),
            dbTypeComboBox.getValue()
        );

        String outputDir = outputDirField.getText();

        if (outputDir.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select an output directory.");
            return;
        }

        EntityGeneratorConfig config = new EntityGeneratorConfig();
        config.setAddBuilderAnnotation(builderAnnotationCheckBox.isSelected());
        config.setNameConverter(getNameConverter(namingConventionComboBox.getValue()));

        entityGenerator = new EntityGenerator(config);


        new Thread(() -> {
            try {
                entityGenerator.generateEntities(dbConfig, outputDir, this::updateProgress);
                showAlert(Alert.AlertType.INFORMATION, "Generation Complete", "JPA entities have been generated successfully.");
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Generation Failed", "An error occurred while generating entities: " + e.getMessage());
            }
        }).start();
    }

    private void updateProgress(double progress) {
        progressBar.setProgress(progress);
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private Function<String, String> getNameConverter(String convention) {
        switch (convention) {
            case "PascalCase":
                return this::toPascalCase;
            case "camelCase":
                return this::toCamelCase;
            case "snake_case":
                return this::toSnakeCase;
            default:
                return Function.identity();
        }
    }

    private String toPascalCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    private String toCamelCase(String input) {
        return input.substring(0, 1).toLowerCase() + input.substring(1);
    }

    private String toSnakeCase(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }
}

