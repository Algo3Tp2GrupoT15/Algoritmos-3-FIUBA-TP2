package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public interface Preguntas {

    ArrayList<Opcion> opciones();

    int asignarPuntaje(Respuesta respuesta);

    String contenido();

    ArrayList<Opcion> opcionesCorrectas();

}