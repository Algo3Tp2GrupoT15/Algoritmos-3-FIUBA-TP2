package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta;

public class TipoParcial implements TipoPuntaje {

    public void asignarPuntaje(Respuesta respuesta, int cantidadDeCorrectas) {

        if (respuesta.cantidadDeOpcionesIncorrectas() == 0)

            respuesta.asignarPuntajeAlJugador(respuesta.cantidadDeOpcionesCorrectas());

    }

}
