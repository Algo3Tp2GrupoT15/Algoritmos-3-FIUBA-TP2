package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta;

public class TipoClasico implements TipoPuntaje {

    public void asignarPuntaje(Respuesta respuesta, int cantidadDeCorrectas){

        if(cantidadDeCorrectas == respuesta.cantidadDeOpcionesCorrectas())

            respuesta.asignarPuntajeAlJugador(1);

    }

}
