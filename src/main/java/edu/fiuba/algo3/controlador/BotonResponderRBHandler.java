package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class BotonResponderRBHandler implements EventHandler<ActionEvent> {

    private final Text texto;
    private final Button boton;
    private final KahootModel kahoot;
    private final ArrayList<RadioButton> radioButtons;
    private final Respuesta respuesta;

    public BotonResponderRBHandler(Respuesta respuesta,KahootModel kahoot, Text texto, Button responder, ArrayList<RadioButton> opciones) {

        this.texto = texto;
        this.boton = responder;
        this.kahoot = kahoot;
        this.radioButtons=opciones;
        this.respuesta=respuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        for(int i=0; i<radioButtons.size();i++){
            if(radioButtons.get(i).isSelected()){
                String texto=radioButtons.get(i).getText();
                Opcion opcion = buscarOpcion(texto);
                respuesta.agregarOpcion(opcion);
            }

        }

        this.texto.setText("Puntaje de "+ kahoot.jugadorDeTurno().nombre()+" : "+kahoot.jugadorDeTurno().puntaje());
        this.boton.setDisable(true);

    }


    Opcion buscarOpcion(String item) {
        for(Opcion opcion : kahoot.mostrarOpcionesDeTurno()) {
            if(opcion.contenido().equals(item)) {
                return opcion;
            }
        }
        return null;
    }


}
