package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta;

public class TipoClásico extends TipoPuntaje {

    public void asignarPuntaje(Respuesta respuesta, int cantidadDeCorrectas){

        if(cantidadDeCorrectas == respuesta.cantidadDeOpcionesCorrectas())

            respuesta.asignarPuntajeAlJugador(1);

    }

}
