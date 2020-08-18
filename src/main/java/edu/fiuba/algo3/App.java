package edu.fiuba.algo3;

import com.google.gson.*;

import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Preguntas;
import edu.fiuba.algo3.modelo.preguntas.TipoClasico;
import edu.fiuba.algo3.modelo.preguntas.TipoPuntaje;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;
import edu.fiuba.algo3.vista.BienvenidosVista;
import edu.fiuba.algo3.vista.InicioDelJuegoVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

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