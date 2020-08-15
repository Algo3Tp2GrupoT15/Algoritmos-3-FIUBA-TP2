package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.preguntas.Preguntas;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.control.*;

public class BotonResponderHandler implements EventHandler<ActionEvent> {

    private final Preguntas pregunta;
    private final Respuesta respuesta;
    private final Text texto;
    private final Button boton;

    public BotonResponderHandler(Preguntas pregunta, Respuesta respuesta, Text texto, Button responder) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.texto = texto;
        this.boton = responder;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.pregunta.asignarPuntaje(respuesta);
        this.texto.setText("Puntaje: "+ this.respuesta.puntajeDelJugador());
        this.boton.setDisable(true);

    }


}
