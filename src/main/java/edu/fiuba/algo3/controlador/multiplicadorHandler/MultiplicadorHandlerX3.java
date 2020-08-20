package edu.fiuba.algo3.controlador.multiplicadorHandler;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.KahootModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MultiplicadorHandlerX3 extends MultiplicadorHandler {


    public MultiplicadorHandlerX3(Button boton, KahootModel kahootModel) {
        super(boton, kahootModel);

        if (!this.kahootModel.jugadorDeTurno().tieneMultiplicadorX3() || !this.kahootModel.preguntaDeTurno().tipo().hayMultiplicadores()){


            this.boton.setDisable(true);
        }


    }


    @Override
    public void handle(ActionEvent actionEvent) {

        this.kahootModel.jugadorDeTurno().multiplicadorX3();
        this.boton.setDisable(true);

    }

}
