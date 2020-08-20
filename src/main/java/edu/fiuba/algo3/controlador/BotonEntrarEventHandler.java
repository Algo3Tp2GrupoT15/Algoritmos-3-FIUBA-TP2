package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {


    private Stage stage;
    private Scene proximaEscena;
    private MediaPlayer mediaPlayer;

    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena, MediaPlayer mediaPlayer) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        stage.setFullScreen(false);
        mediaPlayer.stop();
    }
}

