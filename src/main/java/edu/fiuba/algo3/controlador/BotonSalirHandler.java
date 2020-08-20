package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class BotonSalirHandler implements EventHandler<ActionEvent> {

    private final Stage stage;

    public BotonSalirHandler(Stage stage, KahootModel kahoot) {

        this.stage = stage;

    }

    public void handle(ActionEvent actionEvent) {

        this.stage.setOnCloseRequest(e->{
            System.exit(0);
        });
        this.stage.close();

    }


}
