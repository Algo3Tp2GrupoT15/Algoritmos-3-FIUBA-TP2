package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.vista.GroupChoiceVista;
import edu.fiuba.algo3.vista.MultipleChoiceVista;
import edu.fiuba.algo3.vista.OrderedChoiceVista;
import edu.fiuba.algo3.vista.VerdaderoFalsoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BotonSiguienteHandler implements EventHandler<ActionEvent> {

    Stage vista;
    KahootModel kahoot;
    DetectorDeVista  siguientePregunta;


    public BotonSiguienteHandler(Stage vista, KahootModel kahoot) {

        this.vista = vista;
        this.kahoot = kahoot;
        siguientePregunta = new DetectorDeVista(kahoot);

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        // Acá kahoot debe activar la siguiente ventana.
        kahoot.proximaPreguntaDeTurno();

        switch (kahoot.preguntaDeTurno().tipoDePregunta()){

            case "VerdaderoYFalso":
                siguientePregunta.siguienteVistaPregunta((VerdaderoYFalso) kahoot.preguntaDeTurno(), vista);
                break;

            case "MultipleChoice" :
                siguientePregunta.siguienteVistaPregunta((MultipleChoice) kahoot.preguntaDeTurno(), vista);
                break;

            case "OrderedChoice" :
                siguientePregunta.siguienteVistaPregunta((OrderedChoice) kahoot.preguntaDeTurno(), vista);
                break;
            case "GroupChoice" :
                siguientePregunta.siguienteVistaPregunta((GroupChoice) kahoot.preguntaDeTurno(), vista);
                break;
        }

        //vista.close();

    }



}
