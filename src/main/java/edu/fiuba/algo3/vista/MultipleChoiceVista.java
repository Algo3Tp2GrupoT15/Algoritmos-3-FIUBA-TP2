package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MultipleChoiceVista extends Application {


    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) { //prueba para ver la vista de una pregunta MultipleChoice

        stage.setTitle("Kahoot Algos 3");

        Text tipoDePregunta = new Text("MultipleChoice Clasico");
        tipoDePregunta.setFont(Font.font("Arial", FontWeight.BLACK, 36));
        Text pregunta = new Text(" 2+2=..? ");
        pregunta.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        pregunta.setFill(Color.BLUE);


        RadioButton opcionCorrecta = new RadioButton("4");
        RadioButton opcionCorrecta2 = new RadioButton("2^2");
        RadioButton opcionIncorrecta = new RadioButton("8");
        RadioButton opcionIncorrecta2 = new RadioButton("Pez");

        FlowPane flowpane = new FlowPane();
        flowpane.getChildren().add(opcionCorrecta);
        flowpane.getChildren().add(opcionCorrecta2);
        flowpane.getChildren().add(opcionIncorrecta);
        flowpane.getChildren().add(opcionIncorrecta2);
        flowpane.setHgap(50);
        flowpane.setAlignment(Pos.CENTER);

        Button responder = new Button("Responder");

        VBox vbox = new VBox(tipoDePregunta,pregunta, flowpane, responder);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        Scene scene = new Scene(vbox, 480, 360);
        stage.setScene(scene);
        stage.show();




    }
}


