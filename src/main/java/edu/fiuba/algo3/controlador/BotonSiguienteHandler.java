package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class BotonSiguienteHandler  extends BotonSiguienteVistaHandler {



    public BotonSiguienteHandler(Stage stage, KahootModel kahoot) {

      super(stage, kahoot);


    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.siguienteVista();

    }


}
