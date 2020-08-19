package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteVistaHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PuntosVista extends VBox {

    private Stage stage;
    private KahootModel kahoot;

    public PuntosVista(Stage stage, KahootModel kahoot) {

        super();

        this.stage = stage;
        this.kahoot = kahoot;

        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));


        int i = 1;

        for (Jugador jugador : kahoot.jugadores()){

            Text puntaje = new Text(i + " - Puesto con puntaje de " + jugador.nombre() + " : "+ jugador.puntaje());
            puntaje.setFont(Font.font("Arial", FontWeight.BLACK, 20));
            this.getChildren().add(puntaje);

            i++;

        }

        Button continuar = new Button("Siguiente");
        BotonSiguienteHandler botonSiguienteHandler = new BotonSiguienteHandler(stage,kahoot);
        continuar.setOnAction(botonSiguienteHandler);

        this.getChildren().add(continuar);
        this.setAlignment(Pos.CENTER);

    }


}
