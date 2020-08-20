package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonExclusividadHandler  implements EventHandler<ActionEvent> {

    private Button activarExclusividad;
    private KahootModel kahootModel;

    public BotonExclusividadHandler(Button activarExclusividad, KahootModel kahootModel) {
        this.activarExclusividad = activarExclusividad;
        this.kahootModel = kahootModel;

        desactivarBotton();

    }

    private void desactivarBotton() {
        if (kahootModel.jugadorDeTurno().getUsosExclusividad() <= 0 || !this.kahootModel.preguntaDeTurno().tipo().hayExclusividad()) {
            activarExclusividad.setDisable(true);
        }

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        kahootModel.activarExclusividad(kahootModel.jugadorDeTurno().getUsosExclusividad());
        kahootModel.jugadorDeTurno().disminuirUsosExclusividad();
        this.activarExclusividad.setDisable(true);

    }
}
