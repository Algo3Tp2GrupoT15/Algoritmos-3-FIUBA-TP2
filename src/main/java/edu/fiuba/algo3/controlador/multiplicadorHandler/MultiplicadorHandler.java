package edu.fiuba.algo3.controlador.multiplicadorHandler;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.KahootModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MultiplicadorHandler implements EventHandler<ActionEvent> {


    protected Button boton;
    protected KahootModel kahootModel;


    public MultiplicadorHandler(Button boton, KahootModel kahootModel){

        this.boton = boton;
        this.kahootModel = kahootModel;
    }


    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
