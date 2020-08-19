package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.KahootModel;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.nio.BufferUnderflowException;

public class InicioDelJuegoVista extends VBox {


    private Stage stage;


    public  InicioDelJuegoVista(Stage stage, KahootModel kahoot) {

        super();

        this.stage = stage;

        File path = new File("src/main/java/recursos/kahoot-lobby-music.mp3");
        Media media = new Media(path.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        Text ingreseNombreJugador1 = new Text("Nombre Jugador 1: ");
        TextField nombreJugador1 = new TextField();
        Text ingreseNombreJugador2 = new Text("Nombre Jugador 2: ");
        TextField nombreJugador2 = new TextField();

        HBox iniciarJugador1 = new HBox(ingreseNombreJugador1,nombreJugador1);
        iniciarJugador1.setAlignment(Pos.CENTER);
        HBox iniciarJugador2 = new HBox(ingreseNombreJugador2,nombreJugador2);
        iniciarJugador2.setAlignment(Pos.CENTER);
        Button aceptar = new Button("Aceptar y Empezar");
        Text validacion = new Text("");

        aceptar.setOnAction(value ->  {

            kahoot.cargarJugador(nombreJugador1.getText());
            kahoot.cargarJugador(nombreJugador2.getText());
            validacion.setText("Se crearon los jugadores: \n"+  "1 - " + nombreJugador1.getText() +"\n2 - "+ nombreJugador2.getText());


        });



        Button continuar = new Button("continuar");

        continuar.setOnAction(value ->  {
            VerdaderoFalsoVista proximaPregunta = new VerdaderoFalsoVista(stage, kahoot);
            //MultipleChoiceVista proximaPregunta = new MultipleChoiceVista(stage, kahoot);
            Scene proximaEscena = new Scene(proximaPregunta, 1080, 720);
            stage.setScene(proximaEscena);

        });



        this.getChildren().addAll(iniciarJugador1, iniciarJugador2, aceptar, validacion, continuar);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);


    }
}

