package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta;

public class TipoConPenalidad implements TipoPuntaje {

    public void asignarPuntaje(Respuesta respuesta, int cantidadDeCorrectas){

        int puntaje = respuesta.cantidadDeOpcionesCorrectas() - respuesta.cantidadDeOpcionesIncorrectas();

        respuesta.asignarPuntajeAlJugador(puntaje);

    }

}
