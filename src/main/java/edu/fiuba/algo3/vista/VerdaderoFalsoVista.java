package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonRadioHandler;
import edu.fiuba.algo3.controlador.BotonResponderHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.TipoClasico;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;
import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.ArrayList;

import static javafx.beans.binding.Bindings.createStringBinding;

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

        RadioButton opcion1 = new RadioButton(this.opcionCorrecta.contenido());
        flowpane.getChildren().add(opcion1);
        opcion1.setToggleGroup(opciones);
        BotonRadioHandler botonRadioHandler1 = new BotonRadioHandler(respuesta,this.opcionCorrecta);
        opcion1.setOnAction(botonRadioHandler1);
        RadioButton opcion2 = new RadioButton(this.opcionIncorrecta.contenido());
        flowpane.getChildren().add(opcion2);
        opcion2.setToggleGroup(opciones);
        BotonRadioHandler botonRadioHandler2 = new BotonRadioHandler(respuesta,this.opcionIncorrecta);
        opcion2.setOnAction(botonRadioHandler2);

        flowpane.setHgap(50);
        flowpane.setAlignment(Pos.CENTER);

        Text puntaje = new Text();
        puntaje.setFont(Font.font("Arial", FontWeight.BLACK, 20));
        puntaje.textProperty().bind(createStringBinding(() -> "Puntaje: "+ respuesta.puntajeDelJugador()));

        Button responder = new Button("Responder");
        //flowpane.getChildren().add(responder);
        BotonResponderHandler botonResponderHandler = new BotonResponderHandler(this.pregunta,this.respuesta,puntaje);
        responder.setOnAction(botonResponderHandler);

        this.getChildren().addAll(turnoDelJugador,tipoDePregunta,pregunta, flowpane, responder);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

    }

    public void crearModelo(){

        KahootModel kahoot= new KahootModel();

        Jugador jugador1 = new Jugador();

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        TipoClasico tipoClásico = new TipoClasico();

        VerdaderoYFalso verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opciones,tipoClásico);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);

        this.pregunta = verdaderoYFalso;
        this.respuesta = respuestaJugador1;
        this.opcionCorrecta = opcionCorrecta;
        this.opcionIncorrecta = opcionIncorrecta;

    }

}
