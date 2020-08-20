package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.vista.FinalVista;
import edu.fiuba.algo3.vista.Clock;
import edu.fiuba.algo3.vista.PuntosVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BotonSiguienteVistaHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private KahootModel kahoot;
    private DetectorDeVista  siguientePregunta;
    private Clock clock;
    protected MediaPlayer mediaPlayer;


    public BotonSiguienteVistaHandler(Stage stage, KahootModel kahoot, Clock clock, MediaPlayer mediaPlayer) {

        this.stage = stage;
        this.kahoot = kahoot;
        siguientePregunta = new DetectorDeVista(kahoot);

        this.clock = clock;
        this.mediaPlayer = mediaPlayer;
    }

    public BotonSiguienteVistaHandler(Stage stage, KahootModel kahoot, MediaPlayer mediaPlayer) {

        this.stage = stage;
        this.kahoot = kahoot;
        siguientePregunta = new DetectorDeVista(kahoot);
        this.mediaPlayer = mediaPlayer;

    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.mediaPlayer.stop();

        if (kahoot.esUltimaPregunta() && kahoot.ultimoJugador()){

            siguientePregunta.siguienteVistaPregunta(new FinalVista(stage, kahoot), stage);
            return;

        }

        this.clock.terminar();

        if (kahoot.ultimoJugador()){
            kahoot.calcularPuntosDelTurno();
            kahoot.proximaPreguntaDeTurno();
            siguientePregunta.siguienteVistaPregunta(new PuntosVista(stage, kahoot), stage);
        }else {
            kahoot.siguienteJugador();
            siguienteVista();

        }

    }

    public void siguienteVista() {
        switch (kahoot.preguntaDeTurno().tipoDePregunta()){

            case "VerdaderoYFalso":
                siguientePregunta.siguienteVistaPregunta((VerdaderoYFalso) kahoot.preguntaDeTurno(), stage);
                break;

            case "MultipleChoice" :
                siguientePregunta.siguienteVistaPregunta((MultipleChoice) kahoot.preguntaDeTurno(), stage);
                break;

            case "OrderedChoice" :
                siguientePregunta.siguienteVistaPregunta((OrderedChoice) kahoot.preguntaDeTurno(), stage);
                break;
            case "GroupChoice" :
                siguientePregunta.siguienteVistaPregunta((GroupChoice) kahoot.preguntaDeTurno(), stage);
                break;
        }
    }


}
