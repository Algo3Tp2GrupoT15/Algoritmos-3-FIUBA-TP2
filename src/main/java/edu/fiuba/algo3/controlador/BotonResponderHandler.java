package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.preguntas.Preguntas;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class BotonResponderHandler implements EventHandler<ActionEvent> {

    private final Preguntas pregunta;
    private final Respuesta respuesta;
    private final Text texto;

    public BotonResponderHandler(Preguntas pregunta, Respuesta respuesta, Text texto) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.texto = texto;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.pregunta.asignarPuntaje(respuesta);
        texto.setText("Puntaje: "+ this.respuesta.puntajeDelJugador());
    }


}
