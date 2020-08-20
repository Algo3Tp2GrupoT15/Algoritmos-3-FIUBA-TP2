package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import javafx.event.ActionEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BotonSiguienteHandler  extends BotonSiguienteVistaHandler {



    public BotonSiguienteHandler(Stage stage, KahootModel kahoot, MediaPlayer mediaPlayer) {

      super(stage, kahoot, mediaPlayer);


    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.siguienteVista();
        this.mediaPlayer.stop();

    }


}
