package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.controlador.multiplicadorHandler.MultiplicadorHandlerX2;
import edu.fiuba.algo3.controlador.multiplicadorHandler.MultiplicadorHandlerX3;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.KahootModel;

import java.io.File;
import java.util.ArrayList;

public class MultipleChoiceVista extends VBox {

    private Stage stage;
    private Respuesta respuesta;
    private KahootModel kahoot;
    private ArrayList<RadioButton> radioButtons;

    public MultipleChoiceVista(Stage stage, KahootModel kahoot) { //prueba para ver la vista de una pregunta MultipleChoice

        this.stage = stage;
        this.kahoot = kahoot;

        this.crearRespuesta();

        Image imagen = new Image("file:src/main/java/recursos/imagen.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(imagenDeFondo));

        File path = new File("src/main/java/recursos/kahoot-lobby-music.mp3");
        Media media = new Media(path.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        Button activarExclusividad = new Button("Exclusividad");
        BotonExclusividadHandler exclusividadHandler = new BotonExclusividadHandler(activarExclusividad, kahoot);
        activarExclusividad.setOnAction(exclusividadHandler);
        HBox modificadoresDePuntos = new HBox(activarExclusividad);

        GridPane gridPane = new GridPane();
        crearMultipicadores(gridPane);
        modificadoresDePuntos.getChildren().add(gridPane);
        modificadoresDePuntos.setSpacing(600);
        modificadoresDePuntos.setAlignment(Pos.CENTER);


        Text turnoDelJugador = new Text(kahoot.jugadorDeTurno().nombre());
        turnoDelJugador.setFont(Font.font("Arial", FontWeight.THIN, 30));
        Text tipoDePregunta = new Text("MultipleChoice Clasico");
        tipoDePregunta.setFont(Font.font("Arial", FontWeight.BLACK, 36));
        Text pregunta = new Text(kahoot.preguntaDeTurno().contenido());
        pregunta.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        pregunta.setFill(Color.BLUE);

        FlowPane flowpane = new FlowPane();
        crearOpciones(flowpane);
        flowpane.setHgap(50);
        flowpane.setAlignment(Pos.CENTER);


        Text puntaje1 = new Text("Puntaje de "+ kahoot.jugadorDeTurno().nombre()+" : "+kahoot.jugadorDeTurno().puntaje());
        puntaje1.setFont(Font.font("Arial", FontWeight.BLACK, 20));

        Button responder = new Button("Responder");
        BotonResponderRBHandler botonResponderRBHandler = new BotonResponderRBHandler(respuesta,kahoot,puntaje1,responder,radioButtons);
        responder.setOnAction(botonResponderRBHandler);

        Button continuar = new Button("Siguiente");
        Clock clock = new Clock(continuar);
        BotonSiguienteVistaHandler botonSiguienteHandler = new BotonSiguienteVistaHandler(stage,kahoot, clock,mediaPlayer);
        continuar.setOnAction(botonSiguienteHandler);



        this.getChildren().addAll(modificadoresDePuntos,turnoDelJugador,tipoDePregunta,pregunta,puntaje1,flowpane,responder,continuar, clock);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

    }


    public void crearRespuesta(){

        Respuesta respuestaJugador1 = new Respuesta(kahoot.jugadorDeTurno());
        kahoot.cargarRespuestas(respuestaJugador1);

        this.respuesta = respuestaJugador1;

    }

    private void crearOpciones(FlowPane flowpane) {

        this.radioButtons = new ArrayList<>();

        for (int i=0; i<kahoot.mostrarOpcionesDeTurno().size();i++) {
            RadioButton opcionRB = new RadioButton(kahoot.mostrarOpcionesDeTurno().get(i).contenido());
            flowpane.getChildren().add(opcionRB);
            BotonRadioHandler botonRadioHandler = new BotonRadioHandler(respuesta,kahoot.mostrarOpcionesDeTurno().get(i));
            opcionRB.setOnAction(botonRadioHandler);
            this.radioButtons.add(opcionRB);
        }
    }

    private void crearMultipicadores(GridPane gridPane) {
        Button multiplicadorX2 = new Button("MultiplicadorX2");
        Button multiplicadorX3 = new Button("MultiplicadorX3");
        MultiplicadorHandlerX2 x2 = new MultiplicadorHandlerX2(multiplicadorX2,kahoot);
        MultiplicadorHandlerX3 x3 = new MultiplicadorHandlerX3(multiplicadorX3,kahoot);
        multiplicadorX2.setOnAction(x2);
        multiplicadorX3.setOnAction(x3);


        gridPane.add(multiplicadorX2, 0, 0, 1, 1);
        gridPane.add(multiplicadorX3, 0, 1, 1, 1);


    }

}


