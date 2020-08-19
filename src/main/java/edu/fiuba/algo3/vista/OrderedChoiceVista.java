package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonResponderHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteVistaHandler;
import edu.fiuba.algo3.controlador.ComboBoxHandler;
import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.FlowPane;
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

public class OrderedChoiceVista extends VBox {

    private Stage stage;
    private Respuesta respuesta;
    private KahootModel kahoot;

    public OrderedChoiceVista(Stage stage, KahootModel kahoot) { //prueba para ver la vista de una pregunta MultipleChoice

        this.stage = stage;
        this.kahoot = kahoot;

        this.crearRespuesta();

        File path = new File("src/main/java/recursos/kahoot-lobby-music.mp3");
        Media media = new Media(path.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        stage.setTitle("Kahoot Algos 3");

        Text turnoDelJugador = new Text(kahoot.jugadorDeTurno().nombre());

        Text tipoDePregunta = new Text("Ordered Choice");
        tipoDePregunta.setFont(Font.font("Arial", FontWeight.BLACK, 36));
        Text pregunta = new Text(kahoot.preguntaDeTurno().contenido());
        pregunta.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        pregunta.setFill(Color.BLUE);

        ObservableList<String> opcionesMenu = FXCollections.observableArrayList();
        StackPane stackpane = new StackPane();
        GridPane gridpane = new GridPane();

        Label label1 = new Label("Orden ");
        gridpane.add(label1, 1,0);
        Label label2 = new Label(" Opción");
        gridpane.add(label2, 2,0 );

        for (int i=0; i<kahoot.mostrarOpcionesDeTurno().size();i++){

            opcionesMenu.add(kahoot.mostrarOpcionesDeTurno().get(i).contenido());

        }

        for (int i=0; i<kahoot.mostrarOpcionesDeTurno().size();i++){

            ComboBox menuOrden = new ComboBox (opcionesMenu);
            gridpane.add(menuOrden,2,(i+1));
            Label label = new Label(String.valueOf(i+1));
            gridpane.add(label, 1, (i+1));
            Object item = menuOrden.getSelectionModel().getSelectedItem();
            Opcion opcion = this.buscarOpcion((String)item);
            ComboBoxHandler comboBoxHandler = new ComboBoxHandler(respuesta,opcion);
            menuOrden.setOnAction(comboBoxHandler);
        }

        gridpane.setAlignment(Pos.CENTER);
        stackpane.getChildren().add(gridpane);



      /*  FlowPane flowpane = new FlowPane();
        flowpane.setHgap(50);
        flowpane.setAlignment(Pos.CENTER);

        for (int i=0; i<kahoot.mostrarOpcionesDeTurno().size();i++) {
            RadioButton opcionRB = new RadioButton(kahoot.mostrarOpcionesDeTurno().get(i).contenido());
            flowpane.getChildren().add(opcionRB);
            BotonRadioHandler botonRadioHandler = new BotonRadioHandler(respuesta,kahoot.mostrarOpcionesDeTurno().get(i));
            opcionRB.setOnAction(botonRadioHandler);

        }*/

        Text puntaje1 = new Text("Puntaje de "+kahoot.jugadorDeTurno().nombre()+" : "+respuesta.puntajeDelJugador());
        puntaje1.setFont(Font.font("Arial", FontWeight.BLACK, 20));

        Button responder = new Button("Responder");
        BotonResponderHandler botonResponderHandler = new BotonResponderHandler(kahoot,puntaje1,responder);
        responder.setOnAction(botonResponderHandler);

        Button continuar = new Button("Siguiente");
        BotonSiguienteVistaHandler botonSiguienteHandler = new BotonSiguienteVistaHandler(stage,kahoot);
        continuar.setOnAction(botonSiguienteHandler);

        this.getChildren().addAll(turnoDelJugador,tipoDePregunta,pregunta,puntaje1,stackpane,responder,continuar);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

    }


    public void crearRespuesta(){

        Respuesta respuestaJugador1 = new Respuesta(kahoot.jugadorDeTurno());
        kahoot.cargarRespuestas(respuestaJugador1);

        this.respuesta = respuestaJugador1;

    }


    Opcion buscarOpcion(String item) {
        for(Opcion opcion : kahoot.mostrarOpcionesDeTurno()) {
            if(opcion.contenido().equals(item)) {
                return opcion;
            }
        }
        return null;
    }

}


