package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.KahootModel;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
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


        Image imagen = new Image("file:src/main/java/recursos/ParallelIncredibleEarthworm-small.gif");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,  new BackgroundSize(0.1, 0.1, true, true, false, false));
        this.setBackground(new Background(imagenDeFondo));

        Text ingreseNombreJugador1 = new Text("Nombre Jugador 1: ");
        ingreseNombreJugador1.setFill(Color.WHITE);
        ingreseNombreJugador1.setFont(Font.font("Courier 10 Pitch",FontWeight.BOLD, FontPosture.REGULAR,46));
        TextField nombreJugador1 = new TextField();
        Text ingreseNombreJugador2 = new Text("Nombre Jugador 2: ");
        ingreseNombreJugador2.setFill(Color.WHITE);
        ingreseNombreJugador2.setFont(Font.font("Courier 10 Pitch",FontWeight.BOLD, FontPosture.REGULAR,46));
        TextField nombreJugador2 = new TextField();

        HBox iniciarJugador1 = new HBox(ingreseNombreJugador1,nombreJugador1);
        iniciarJugador1.setAlignment(Pos.CENTER);
        HBox iniciarJugador2 = new HBox(ingreseNombreJugador2,nombreJugador2);
        iniciarJugador2.setAlignment(Pos.CENTER);
        Button aceptar = new Button("Aceptar y Empezar");
        Text validacion = new Text("");
        validacion.setFill(Color.WHITE);
        validacion.setFont(Font.font("Courier 10 Pitch",FontWeight.BOLD, FontPosture.REGULAR,26));

        aceptar.setOnAction(value ->  {

            kahoot.cargarJugador(nombreJugador1.getText());
            kahoot.cargarJugador(nombreJugador2.getText());
            validacion.setText("Se crearon los jugadores: \n"+  "1 - " + nombreJugador1.getText() +"\n2 - "+ nombreJugador2.getText());


        });



        Button continuar = new Button("continuar");
        BotonSiguienteHandler siguienteVista = new BotonSiguienteHandler(stage, kahoot);
        continuar.setOnAction(siguienteVista);


        this.getChildren().addAll(iniciarJugador1, iniciarJugador2, aceptar, validacion, continuar);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);


    }
}

