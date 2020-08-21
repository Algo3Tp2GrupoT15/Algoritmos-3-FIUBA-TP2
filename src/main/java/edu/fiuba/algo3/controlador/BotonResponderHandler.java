package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import edu.fiuba.algo3.modelo.KahootModel;

public class BotonResponderHandler implements EventHandler<ActionEvent> {

    private final Text texto;
    private final Button boton;
    private final KahootModel kahoot;

    public BotonResponderHandler(KahootModel kahoot, Text texto, Button responder) {

        this.texto = texto;
        this.boton = responder;
        this.kahoot = kahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.texto.setText("Puntaje acumulado de " + kahoot.jugadorDeTurno().nombre()+" : "+kahoot.jugadorDeTurno().puntaje());
        this.boton.setDisable(true);

    }


}
