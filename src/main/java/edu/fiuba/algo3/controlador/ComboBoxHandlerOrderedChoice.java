package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionGroup;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class ComboBoxHandlerOrderedChoice implements EventHandler<ActionEvent> {

    private final Respuesta respuesta;
    private final KahootModel kahoot;
    private final ComboBox comboBox;

    public ComboBoxHandlerOrderedChoice(KahootModel kahoot, ComboBox comboBox, Respuesta respuesta) {
        this.respuesta = respuesta;
        this.kahoot = kahoot;
        this.comboBox = comboBox;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        /*   this.respuesta.eliminarOpciones();*/
        Object item = this.comboBox.getSelectionModel().getSelectedItem();
        Opcion opcion = this.buscarOpcion((String)item);

        this.respuesta.agregarOpcion(opcion);


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