package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonResponderHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteVistaHandler;
import edu.fiuba.algo3.controlador.ComboBoxHandlerGroupChoice;
import edu.fiuba.algo3.controlador.ComboBoxHandlerOrderedChoice;
import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionGroup;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class OrderedChoiceVista extends VBox {

    private Stage stage;
    private Respuesta respuesta;
    private KahootModel kahoot;
    private ArrayList<Opcion> opcionesList;

    public OrderedChoiceVista(Stage stage, KahootModel kahoot) { //prueba para ver la vista de una pregunta MultipleChoice

        this.stage = stage;
        this.kahoot = kahoot;
        this.opcionesList = kahoot.mostrarOpcionesDeTurno();

        this.crearRespuesta();

        File path = new File("src/main/java/recursos/kahoot-lobby-music.mp3");
        Media media = new Media(path.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        stage.setTitle("Kahoot Algos 3");

        Text turnoDelJugador = new Text(kahoot.jugadorDeTurno().nombre());
        turnoDelJugador.setFont(Font.font("Arial", FontWeight.THIN, 30));
        Text tipoDePregunta = new Text("Ordered Choice");
        tipoDePregunta.setFont(Font.font("Arial", FontWeight.BLACK, 36));
        Text pregunta = new Text(kahoot.preguntaDeTurno().contenido());
        pregunta.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        pregunta.setFill(Color.BLUE);

        String stringOpciones = "Opciones a ordenar:";
        ArrayList<Opcion> opcionesList = kahoot.mostrarOpcionesDeTurno();
        for (int i=0; i<opcionesList.size();i++){
            Opcion opcion = opcionesList.get(i);
            stringOpciones=stringOpciones.concat(" "+opcion.contenido()+",");
        }
        Text muestraOpciones = new Text(stringOpciones);
        muestraOpciones.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        muestraOpciones.setFill(Color.BLUE);


       ObservableList<String> opcionesMenu = FXCollections.observableArrayList();
        StackPane stackpane = new StackPane();
        GridPane gridpane = new GridPane();

        Label label1 = new Label("Orden ");
        gridpane.add(label1, 1,0);
        Label label2 = new Label(" Opción");
        gridpane.add(label2, 2,0 );

        for (int i=0; i<opcionesList.size();i++){

            Opcion opcion = opcionesList.get(i);
            opcionesMenu.add(opcion.contenido());

        }

        for (int i=0; i<opcionesList.size();i++){

            ComboBox menuOrden = new ComboBox (opcionesMenu);
            gridpane.add(menuOrden,2,(i+1));
            Label label = new Label(String.valueOf(i+1));
            gridpane.add(label, 1, (i+1));
            ComboBoxHandlerOrderedChoice comboBoxHandlerOrderedChoice = new ComboBoxHandlerOrderedChoice(menuOrden,respuesta,opcionesList);
            menuOrden.setOnAction(comboBoxHandlerOrderedChoice);
        }

        gridpane.setAlignment(Pos.CENTER);
        stackpane.getChildren().add(gridpane);

        Text puntaje1 = new Text("Puntaje de "+ kahoot.jugadorDeTurno().nombre()+" : "+kahoot.jugadorDeTurno().puntaje());
        puntaje1.setFont(Font.font("Arial", FontWeight.BLACK, 20));

        Button responder = new Button("Responder");
        BotonResponderHandler botonResponderHandler = new BotonResponderHandler(kahoot,puntaje1,responder);
        responder.setOnAction(botonResponderHandler);

        Button continuar = new Button("Siguiente");
        BotonSiguienteVistaHandler botonSiguienteHandler = new BotonSiguienteVistaHandler(stage,kahoot);
        continuar.setOnAction(botonSiguienteHandler);


        Clock clock = new Clock(continuar);

        this.getChildren().addAll(turnoDelJugador,tipoDePregunta,pregunta,muestraOpciones,puntaje1,stackpane,responder,continuar,clock);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

    }


    public void crearRespuesta(){

        Respuesta respuestaJugador1 = new Respuesta(kahoot.jugadorDeTurno());
        kahoot.cargarRespuestas(respuestaJugador1);

        this.respuesta = respuestaJugador1;

    }



}


