package edu.fiuba.algo3.controlador.multiplicadorHandler;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.KahootModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MultiplicadorHandlerX2 extends MultiplicadorHandler {


    public MultiplicadorHandlerX2(Button boton, KahootModel kahootModel) {
        super(boton, kahootModel);

        if (!this.kahootModel.jugadorDeTurno().tieneMultiplicadorX2() || !this.kahootModel.preguntaDeTurno().tipo().hayMultiplicadores()){

            this.boton.setDisable(true);
        }

    }


    @Override
    public void handle(ActionEvent actionEvent) {


        this.kahootModel.jugadorDeTurno().multiplicadorX2();
        this.boton.setDisable(true);

    }

}
