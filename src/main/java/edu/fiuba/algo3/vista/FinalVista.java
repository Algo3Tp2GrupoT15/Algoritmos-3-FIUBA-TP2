package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSalirHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteVistaHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.KahootModel;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FinalVista extends VBox {

    private Stage stage;
    private KahootModel kahoot;

    public FinalVista(Stage stage, KahootModel kahoot) {

        super();

        this.stage = stage;
        this.kahoot = kahoot;

        Jugador jugadorGanador = new Jugador();

        for(Jugador jugador:kahoot.jugadores()){

            if (jugador.puntaje()>jugadorGanador.puntaje()){
                jugadorGanador = jugador;
            }

        }

        Image imagen = new Image("file:src/main/java/recursos/imagen.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(imagenDeFondo));

        Text finalDelJuego = new Text("FIN DEL JUEGO");
        finalDelJuego.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        finalDelJuego.setFill(Color.BLUE);

        Text ganador = new Text("Ganador: "+ jugadorGanador.nombre());
        ganador.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        ganador.setFill(Color.BLUE);

        Text tecla = new Text("Presione el boton para salir...");
        tecla.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        tecla.setFill(Color.BLUE);

        Button salir = new Button("Salir");
        BotonSalirHandler botonSalirHandler = new BotonSalirHandler(stage, kahoot);
        salir.setOnAction(botonSalirHandler);

        this.getChildren().addAll(finalDelJuego,ganador,tecla,salir);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

    }


}
