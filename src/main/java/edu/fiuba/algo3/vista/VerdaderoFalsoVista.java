package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonRadioHandler;
import edu.fiuba.algo3.controlador.BotonResponderHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteHandler;
import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;


public class VerdaderoFalsoVista extends VBox {

    private Stage stage;
    private Respuesta respuesta;
    private KahootModel kahoot;

    public VerdaderoFalsoVista(Stage stage, KahootModel kahoot) { //prueba para ver la vista de una pregunta VyF

        super();

        this.stage = stage;
        this.kahoot = kahoot;

        this.crearRespuesta();

        File path = new File("src/main/java/recursos/kahoot-lobby-music.mp3");
        Media media = new Media(path.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);


        stage.setTitle("Kahoot Algos 3");

        Text turnoDelJugador = new Text(kahoot.jugadorDeTurno().nombre());

        Text tipoDePregunta = new Text("VervaderoFalso Clasico");
        tipoDePregunta.setFont(Font.font("Arial", FontWeight.BLACK, 36));
        Text pregunta = new Text(kahoot.mostrarPreguntaDeTurno());
        pregunta.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        pregunta.setFill(Color.BLUE);
        //pregunta.setTextAlignment(TextAlignment.CENTER);

        FlowPane flowpane = new FlowPane();
        ToggleGroup opciones = new ToggleGroup(); //esto es para que solo se pueda seleccionar una opcion

        for (int i=0; i<kahoot.mostrarOpcionesDeTurno().size();i++) {
            RadioButton opcionRB = new RadioButton(kahoot.mostrarOpcionesDeTurno().get(i).contenido());
            flowpane.getChildren().add(opcionRB);
            opcionRB.setToggleGroup(opciones);
            BotonRadioHandler botonRadioHandler = new BotonRadioHandler(respuesta,kahoot.mostrarOpcionesDeTurno().get(i));
            opcionRB.setOnAction(botonRadioHandler);

        }

        /*RadioButton opcion2RB = new RadioButton(kahoot.mostrarOpcionesDeTurno().get(1).contenido());
        flowpane.getChildren().add(opcion2RB);
        opcion2RB.setToggleGroup(opciones);
        BotonRadioHandler botonRadioHandler2 = new BotonRadioHandler(respuesta,kahoot.mostrarOpcionesDeTurno().get(1));
        opcion2RB.setOnAction(botonRadioHandler2);*/

        flowpane.setHgap(50);
        flowpane.setAlignment(Pos.CENTER);

        Text puntaje1 = new Text("Puntaje: "+ respuesta.puntajeDelJugador());
        puntaje1.setFont(Font.font("Arial", FontWeight.BLACK, 20));

        Button responder = new Button("Responder");
        BotonResponderHandler botonResponderHandler = new BotonResponderHandler(kahoot,puntaje1,responder);
        responder.setOnAction(botonResponderHandler);

        Button continuar = new Button("Siguiente");
        BotonSiguienteHandler botonSiguienteHandler = new BotonSiguienteHandler(stage,kahoot);
        continuar.setOnAction(botonSiguienteHandler);

        this.getChildren().addAll(turnoDelJugador,tipoDePregunta,pregunta,puntaje1,flowpane,responder,continuar);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

    }

    public void crearRespuesta(){

        Respuesta respuestaJugador1 = new Respuesta(kahoot.jugadorDeTurno());
        kahoot.cargarRespuestas(respuestaJugador1);

        this.respuesta = respuestaJugador1;

    }

}
