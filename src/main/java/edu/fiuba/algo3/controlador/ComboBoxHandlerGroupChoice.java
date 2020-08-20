package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.scene.control.ComboBox;

public class ComboBoxHandlerGroupChoice implements EventHandler<ActionEvent> {

    private final Respuesta respuesta;
    private final KahootModel kahoot;
    private final ComboBox comboBox;

    public ComboBoxHandlerGroupChoice(KahootModel kahoot, ComboBox comboBox, Respuesta respuesta) {
        this.respuesta = respuesta;
        this.kahoot = kahoot;
        this.comboBox = comboBox;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        /*   this.respuesta.eliminarOpciones();*/
        Object item = this.comboBox.getSelectionModel().getSelectedItem();
        OpcionGroup opcion = this.buscarOpcion((String)item);

        this.respuesta.agregarOpcion(opcion);


    }

    OpcionGroup buscarOpcion(String item) {
        for(int i=0;i<kahoot.mostrarOpcionesDeTurno().size();i++) {
            OpcionGroup opcion = (OpcionGroup)kahoot.mostrarOpcionesDeTurno().get(i);
            if(opcion.getGrupo().equals(item)) {
                return opcion;
            }
        }
        return null;
    }


}