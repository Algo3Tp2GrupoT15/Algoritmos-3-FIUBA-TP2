package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionGroup;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class ComboBoxHandlerOrderedChoice implements EventHandler<ActionEvent> {

    private final Respuesta respuesta;
    private final ComboBox comboBox;
    private final ArrayList<Opcion> opciones;

    public ComboBoxHandlerOrderedChoice(ComboBox comboBox, Respuesta respuesta, ArrayList<Opcion> opciones) {
        this.respuesta = respuesta;
        this.comboBox = comboBox;
        this.opciones = opciones;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        /*   this.respuesta.eliminarOpciones();*/
        Object item = this.comboBox.getSelectionModel().getSelectedItem();
        Opcion opcion = this.buscarOpcion((String)item);

        this.respuesta.agregarOpcion(opcion);


    }

    Opcion buscarOpcion(String item) {
        for(Opcion opcion : opciones) {
            if(opcion.contenido().equals(item)) {
                return opcion;
            }
        }
        return null;
    }

}