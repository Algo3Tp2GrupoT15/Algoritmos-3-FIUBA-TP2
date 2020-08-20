package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;
import edu.fiuba.algo3.vista.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DetectorDeVista {

    KahootModel kahoot;


    public DetectorDeVista(KahootModel kahoot){

        this.kahoot = kahoot;
    }

    public void siguienteVistaPregunta(VerdaderoYFalso preguntaDeTurno, Stage vista) {

        VerdaderoFalsoVista proximaPregunta = new VerdaderoFalsoVista(vista, kahoot);
        Scene proximaEscena = new Scene(proximaPregunta, 1080, 720);
        vista.setScene(proximaEscena);

    }

    public void siguienteVistaPregunta(MultipleChoice preguntaDeTurno, Stage vista) {

        MultipleChoiceVista proximaPregunta = new MultipleChoiceVista(vista, kahoot);
        Scene proximaEscena = new Scene(proximaPregunta, 1080, 720);
        vista.setScene(proximaEscena);

    }

    public void siguienteVistaPregunta(OrderedChoice preguntaDeTurno, Stage vista) {

        OrderedChoiceVista proximaPregunta = new OrderedChoiceVista(vista, kahoot);
        Scene proximaEscena = new Scene(proximaPregunta, 1080, 720);
        vista.setScene(proximaEscena);

    }
    public void siguienteVistaPregunta(GroupChoice preguntaDeTurno, Stage vista) {

        GroupChoiceVista proximaPregunta = new GroupChoiceVista(vista, kahoot);
        Scene proximaEscena = new Scene(proximaPregunta, 1080, 720);
        vista.setScene(proximaEscena);

    }

    public void siguienteVistaPregunta(PuntosVista puntosVista, Stage vista) {


        Scene proximaEscena = new Scene(puntosVista, 1080, 720);
        vista.setScene(proximaEscena);

    }

    public void siguienteVistaPregunta(FinalVista finalVista, Stage vista) {


        Scene proximaEscena = new Scene(finalVista, 1080, 720);
        vista.setScene(proximaEscena);

    }


}
