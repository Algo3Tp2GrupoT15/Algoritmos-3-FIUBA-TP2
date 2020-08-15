package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Preguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BotonSiguienteHandler implements EventHandler<ActionEvent> {

    Stage vista;
    public BotonSiguienteHandler(Stage vista) {

        this.vista = vista;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        vista.close();

    }


}
