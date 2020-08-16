package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.vista.BienvenidosVista;
import edu.fiuba.algo3.vista.InicioDelJuegoVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Kahoot Algos 3");

        KahootModel kahoot = new KahootModel();

        InicioDelJuegoVista contenedorPrincipal = new InicioDelJuegoVista(stage, kahoot);
        Scene escenaJuego = new Scene(contenedorPrincipal, 1080, 720);

        BienvenidosVista contenedorBienvenidos = new BienvenidosVista(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1080, 720);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(false);

        stage.show();

    }
}