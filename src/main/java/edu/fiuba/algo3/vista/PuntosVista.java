package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteVistaHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class PuntosVista extends VBox {

    private Stage stage;
    private KahootModel kahoot;

    public PuntosVista(Stage stage, KahootModel kahoot) {

        super();

        this.stage = stage;
        this.kahoot = kahoot;

        Image imagen = new Image("file:src/main/java/recursos/imagen.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        File path = new File("src/main/java/recursos/kahoot-lobby-music.mp3");
        Media media = new Media(path.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);


        int i = 1;
        for (Jugador jugador : kahoot.jugadores()){

            Text puntaje = new Text(i + " - Jugador " + jugador.nombre() + " con puntaje  : "+ jugador.puntaje());
            puntaje.setFont(Font.font("Arial", FontWeight.BLACK, 20));
            this.getChildren().add(puntaje);

            i++;

        }

        Button continuar = new Button("Siguiente");
        BotonSiguienteHandler botonSiguienteHandler = new BotonSiguienteHandler(stage,kahoot, mediaPlayer);
        continuar.setOnAction(botonSiguienteHandler);

        this.getChildren().add(continuar);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

    }


}
