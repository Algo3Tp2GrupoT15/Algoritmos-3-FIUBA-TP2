package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonRadioHandler;
import edu.fiuba.algo3.controlador.BotonResponderHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.TipoClasico;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.KahootModel;
import java.util.ArrayList;

public class MultipleChoiceVista extends VBox {

    private Stage stage;
    //private MultipleChoice pregunta;
    private Respuesta respuesta;
    private ArrayList<Opcion> opciones;
    private KahootModel kahoot;

    public MultipleChoiceVista(Stage stage, KahootModel kahoot) { //prueba para ver la vista de una pregunta MultipleChoice

        this.stage = stage;

        this.kahoot = kahoot;

        this.crearModelo();

        stage.setTitle("Kahoot Algos 3");

        Text turnoDelJugador = new Text(kahoot.jugadorDeTurno().nombre());

        Text tipoDePregunta = new Text("MultipleChoice Clasico");
        tipoDePregunta.setFont(Font.font("Arial", FontWeight.BLACK, 36));
        Text pregunta = new Text(" 2+2=..? ");
        pregunta.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        pregunta.setFill(Color.BLUE);

        FlowPane flowpane = new FlowPane();
        flowpane.setHgap(50);
        flowpane.setAlignment(Pos.CENTER);

    /*for (Opcion unaOpcion : kahoot.mostrarOpcionesDeTurno()) {
            RadioButton opcion = new RadioButton(unaOpcion.contenido());
            flowpane.getChildren().add(opcion);
            opcion.setToggleGroup(opciones);
            BotonRadioHandler botonRadioHandler = new BotonRadioHandler(respuesta,unaOpcion);
            opcion.setOnAction(botonRadioHandler);
        }*/

        RadioButton opcion1RB = new RadioButton(this.opciones.get(0).contenido());
        flowpane.getChildren().add(opcion1RB);
        BotonRadioHandler botonRadioHandler1 = new BotonRadioHandler(respuesta,this.opciones.get(0));
        opcion1RB.setOnAction(botonRadioHandler1);

        RadioButton opcion2RB = new RadioButton(this.opciones.get(1).contenido());
        flowpane.getChildren().add(opcion2RB);
        BotonRadioHandler botonRadioHandler2 = new BotonRadioHandler(respuesta,this.opciones.get(1));
        opcion2RB.setOnAction(botonRadioHandler2);

        RadioButton opcion3RB = new RadioButton(this.opciones.get(2).contenido());
        flowpane.getChildren().add(opcion3RB);
        BotonRadioHandler botonRadioHandler3 = new BotonRadioHandler(respuesta,this.opciones.get(2));
        opcion3RB.setOnAction(botonRadioHandler3);

        RadioButton opcion4RB = new RadioButton(this.opciones.get(3).contenido());
        flowpane.getChildren().add(opcion4RB);
        BotonRadioHandler botonRadioHandler4 = new BotonRadioHandler(respuesta,this.opciones.get(3));
        opcion4RB.setOnAction(botonRadioHandler4);

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

        Opcion opcionCorrecta = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionCorrecta2);
        opciones.add(opcionIncorrecta);
        opciones.add(opcionIncorrecta2);

        Respuesta respuestaJugador1 = new Respuesta(kahoot.jugadorDeTurno());
        kahoot.cargarRespuestas(respuestaJugador1);

        //this.pregunta = multipleChoice;
        this.respuesta = respuestaJugador1;
        this.opciones = opciones;
    }

}


