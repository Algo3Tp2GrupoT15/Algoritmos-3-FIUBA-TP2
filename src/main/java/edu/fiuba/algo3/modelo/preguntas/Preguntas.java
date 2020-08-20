package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public interface Preguntas {

    ArrayList<Opcion> opciones();

    void asignarPuntaje(Respuesta respuesta);

    String contenido();

    ArrayList<Opcion> opcionesCorrectas();

    String tipoDePregunta();

    TipoPuntaje tipo();

}
