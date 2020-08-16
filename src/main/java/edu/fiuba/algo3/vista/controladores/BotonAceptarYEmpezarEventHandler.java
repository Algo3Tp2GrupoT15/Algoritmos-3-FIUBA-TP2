package edu.fiuba.algo3.vista.controladores;

import edu.fiuba.algo3.modelo.KahootModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonAceptarYEmpezarEventHandler implements EventHandler<ActionEvent> {

    private KahootModel modelo;
    private TextField nombre1;
    private TextField nombre2;


    public BotonAceptarYEmpezarEventHandler(TextField nombre1, TextField nombre2, KahootModel kahoot){
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.modelo = kahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        modelo.cargarJugador(nombre1.getText());
        modelo.cargarJugador(nombre2.getText());

    }
}
