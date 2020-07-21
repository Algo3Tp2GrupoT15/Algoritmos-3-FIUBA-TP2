package edu.fiuba.algo3.modelo;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Panel extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Kahoot");

        StackPane layout = new StackPane();
        Scene scene = new Scene(layout);
        stage.setScene(scene);

        Button button = new Button();
        button.setText("Boton");
        layout.getChildren().add(button);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

