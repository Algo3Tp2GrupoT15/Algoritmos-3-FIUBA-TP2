package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonResponderHandler implements EventHandler<ActionEvent> {

    private VerdaderoYFalso pregunta;
    private Respuesta respuesta;

    public BotonResponderHandler(VerdaderoYFalso pregunta, Respuesta respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.pregunta.asignarPuntaje(respuesta);
    }


}
