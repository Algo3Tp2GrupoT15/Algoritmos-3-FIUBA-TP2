package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteHandler;
import edu.fiuba.algo3.controlador.BotonRadioHandler;
import edu.fiuba.algo3.controlador.BotonResponderHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.TipoClasico;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;
import edu.fiuba.algo3.modelo.KahootModel;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

public class VerdaderoFalsoVista extends VBox {

    private Stage stage;
    private VerdaderoYFalso pregunta;
    private Respuesta respuesta;
    Opcion opcionCorrecta;
    Opcion opcionIncorrecta;
    private KahootModel kahoot;

    public VerdaderoFalsoVista(Stage stage, KahootModel kahoot) { //prueba para ver la vista de una pregunta VyF

        super();

        this.stage = stage;
        this.kahoot = kahoot;

        this.crearModelo();

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

       /* for (Opcion unaOpcion : kahoot.mostrarOpcionesDeTurno()) {
            RadioButton opcion = new RadioButton(unaOpcion.contenido());
            flowpane.getChildren().add(opcion);
            opcion.setToggleGroup(opciones);
            BotonRadioHandler botonRadioHandler = new BotonRadioHandler(respuesta,unaOpcion);
            opcion.setOnAction(botonRadioHandler);
        }*/

        RadioButton opcion1RB = new RadioButton(this.opcionCorrecta.contenido());
        flowpane.getChildren().add(opcion1RB);
        opcion1RB.setToggleGroup(opciones);
        BotonRadioHandler botonRadioHandler1 = new BotonRadioHandler(respuesta,this.opcionCorrecta);
        opcion1RB.setOnAction(botonRadioHandler1);

        RadioButton opcion2RB = new RadioButton(this.opcionIncorrecta.contenido());
        flowpane.getChildren().add(opcion2RB);
        opcion2RB.setToggleGroup(opciones);
        BotonRadioHandler botonRadioHandler2 = new BotonRadioHandler(respuesta,this.opcionIncorrecta);
        opcion2RB.setOnAction(botonRadioHandler2);

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

    public void crearModelo(){

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);

        Respuesta respuestaJugador1 = new Respuesta(kahoot.jugadorDeTurno());
        kahoot.cargarRespuestas(respuestaJugador1);

        this.respuesta = respuestaJugador1;
        this.opcionCorrecta = opcionCorrecta;
        this.opcionIncorrecta = opcionIncorrecta;

    }

}
