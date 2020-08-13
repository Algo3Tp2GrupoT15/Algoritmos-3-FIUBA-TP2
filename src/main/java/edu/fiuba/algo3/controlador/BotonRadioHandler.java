package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonRadioHandler implements EventHandler<ActionEvent> {

    private Respuesta respuesta;
    private Opcion opcion;

    public BotonRadioHandler(Respuesta respuesta, Opcion opcion) {
        this.respuesta = respuesta;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.respuesta.agregarOpcion(opcion);

    }


}
