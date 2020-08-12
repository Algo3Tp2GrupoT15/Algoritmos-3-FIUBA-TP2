package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InicioDelJuegoVista extends VBox {


    private Stage stage;


    public  InicioDelJuegoVista(Stage stage) {

        super();

        this.stage = stage;

        Text ingreseNombreJugadro1 = new Text("Nombre Jugador 1: ");
        TextField nombreJugador1 = new TextField();
        Text ingreseNombreJugadro2 = new Text("Nombre Jugador 2: ");
        TextField nombreJugador2 = new TextField();

        HBox iniciarJugador1 = new HBox(ingreseNombreJugadro1,nombreJugador1);
        iniciarJugador1.setAlignment(Pos.CENTER);
        HBox iniciarJugador2 = new HBox(ingreseNombreJugadro2,nombreJugador2);
        iniciarJugador2.setAlignment(Pos.CENTER);
        Button aceptar = new Button("Aceptar y Empezar");
        Text validacion = new Text("");

        aceptar.setOnAction(value ->  {
            Jugador jugador1 = new Jugador(nombreJugador1.getText());
            Jugador jugador2 = new Jugador(nombreJugador2.getText());
            validacion.setText("Se crearon los jugadores: \n"+  "1 - " + jugador1.nombre() +"\n2 - "+ jugador2.nombre());

        });

        this.getChildren().addAll(iniciarJugador1, iniciarJugador2, aceptar, validacion);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);


    }
}







