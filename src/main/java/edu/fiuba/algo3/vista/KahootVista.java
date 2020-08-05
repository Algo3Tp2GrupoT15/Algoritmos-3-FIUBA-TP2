package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class KahootVista extends Application {

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) { //prueba para ver la vista de una pregunta VyF

        stage.setTitle("Kahoot Algos 3");

        Text pregunta = new Text("¿El cielo es azul?");
        pregunta.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        pregunta.setFill(Color.BLUE);
        //pregunta.setTextAlignment(TextAlignment.CENTER);

        RadioButton opcionCorrecta = new RadioButton("Verdadero");
        RadioButton opcionIncorrecta = new RadioButton("Falso");
        ToggleGroup opciones = new ToggleGroup(); //esto es para que solo se pueda seleccionar una opcion
        opcionCorrecta.setToggleGroup(opciones);
        opcionIncorrecta.setToggleGroup(opciones);

        FlowPane flowpane = new FlowPane();
        flowpane.getChildren().add(opcionCorrecta);
        flowpane.getChildren().add(opcionIncorrecta);
        flowpane.setHgap(50);
        flowpane.setAlignment(Pos.CENTER);

        Button responder = new Button("Responder");
        //flowpane.getChildren().add(responder);

        VBox vbox = new VBox(pregunta, flowpane, responder);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        Scene scene = new Scene(vbox, 480, 360);
        stage.setScene(scene);
        stage.show();




    }
}
