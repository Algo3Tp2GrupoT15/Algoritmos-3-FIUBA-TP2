package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonRadioHandler;
import edu.fiuba.algo3.controlador.BotonResponderHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.TipoClasico;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
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

import static javafx.beans.binding.Bindings.createStringBinding;

public class MultipleChoiceVista extends Application {

    private MultipleChoice pregunta;
    private Respuesta respuesta;
    private Opcion opcioCorrecta;
    private Opcion opcioIncorrecta;
    private ArrayList<Opcion> opciones;
    private KahootModel kahoot;

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) { //prueba para ver la vista de una pregunta MultipleChoice

        this.crearModelo();

        stage.setTitle("Kahoot Algos 3");

        Text tipoDePregunta = new Text("MultipleChoice Clasico");
        tipoDePregunta.setFont(Font.font("Arial", FontWeight.BLACK, 36));
        Text pregunta = new Text(" 2+2=..? ");
        pregunta.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        pregunta.setFill(Color.BLUE);

        FlowPane flowpane = new FlowPane();
        flowpane.setHgap(50);
        flowpane.setAlignment(Pos.CENTER);
        ToggleGroup opcionesGroup = new ToggleGroup(); //esto es para que solo se pueda seleccionar una opcion


    /*for (Opcion unaOpcion : kahoot.mostrarOpcionesDeTurno()) {
            RadioButton opcion = new RadioButton(unaOpcion.contenido());
            flowpane.getChildren().add(opcion);
            opcion.setToggleGroup(opciones);
            BotonRadioHandler botonRadioHandler = new BotonRadioHandler(respuesta,unaOpcion);
            opcion.setOnAction(botonRadioHandler);
        }*/

        RadioButton opcion1 = new RadioButton(this.opciones.get(0).contenido());
        flowpane.getChildren().add(opcion1);
        opcion1.setToggleGroup(opcionesGroup);
        BotonRadioHandler botonRadioHandler1 = new BotonRadioHandler(respuesta,this.opciones.get(0));
        opcion1.setOnAction(botonRadioHandler1);
        RadioButton opcion2 = new RadioButton(this.opciones.get(1).contenido());
        flowpane.getChildren().add(opcion2);
        opcion2.setToggleGroup(opcionesGroup);
        BotonRadioHandler botonRadioHandler2 = new BotonRadioHandler(respuesta,this.opciones.get(1));
        opcion2.setOnAction(botonRadioHandler2);
        RadioButton opcion3 = new RadioButton(this.opciones.get(2).contenido());
        flowpane.getChildren().add(opcion3);
        opcion3.setToggleGroup(opcionesGroup);
        BotonRadioHandler botonRadioHandler3 = new BotonRadioHandler(respuesta,this.opciones.get(2));
        opcion3.setOnAction(botonRadioHandler3);
        RadioButton opcion4 = new RadioButton(this.opciones.get(3).contenido());
        flowpane.getChildren().add(opcion4);
        opcion4.setToggleGroup(opcionesGroup);
        BotonRadioHandler botonRadioHandler4 = new BotonRadioHandler(respuesta,this.opciones.get(3));
        opcion4.setOnAction(botonRadioHandler4);

        Text puntaje1 = new Text("Puntaje1: "+ respuesta.puntajeDelJugador());
        puntaje1.setFont(Font.font("Arial", FontWeight.BLACK, 20));

        Button responder = new Button("Responder");
        BotonResponderHandler botonResponderHandler = new BotonResponderHandler(this.pregunta,this.respuesta,puntaje1);
        responder.setOnAction(botonResponderHandler);

        VBox vbox = new VBox(tipoDePregunta,pregunta,puntaje1,flowpane,responder);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        Scene scene = new Scene(vbox, 480, 360);
        stage.setScene(scene);
        stage.show();

    }


    public void crearModelo(){

        KahootModel kahoot= new KahootModel();

        Jugador jugador1 = new Jugador();

        kahoot.cargarJugador("Julio");

        Opcion opcionCorrecta = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionCorrecta2);
        opciones.add(opcionIncorrecta);
        opciones.add(opcionIncorrecta2);
        TipoClasico tipoClásico = new TipoClasico();

        MultipleChoice multipleChoice = new MultipleChoice(" 2+2=..? ", opciones, tipoClásico);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);

        kahoot.cargarRespuestas(respuestaJugador1);

        this.pregunta = multipleChoice;
        this.respuesta = respuestaJugador1;
        this.opcioCorrecta = opcionCorrecta;
        this.opcioIncorrecta = opcionIncorrecta;
        this.opciones = opciones;
    }

}


