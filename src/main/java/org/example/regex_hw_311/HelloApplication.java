package org.example.regex_hw_311;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {

    /**
     * The main entry point for the JavaFX application.
     * This method sets up the primary stage and loads the FXML layout.
     *
     * @param stage The primary stage for this application
     * @throws IOException If there is an error loading the FXML file
     */
    @Override
    public void start(Stage stage) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        // Create a scene with the loaded FXML root and specified dimensions
        Scene scene = new Scene(root, 484, 422);

        stage.setTitle("Registration Form");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method that serves as the entry point for the application.
     * It launches the JavaFX application.
     *
     * @param args Command-line arguments passed to the application
     */
    public static void main(String[] args) {
        launch(args);
    }
}
