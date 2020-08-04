package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta;

public class TipoConPenalidad extends TipoPuntaje {

    public void asignarMultiplicador(int factor){

        multiplicador = factor;

    }

    public void asignarPuntaje(Respuesta respuesta, int cantidadDeCorrectas){

        int puntaje = respuesta.cantidadDeOpcionesCorrectas() - respuesta.cantidadDeOpcionesIncorrectas();

        respuesta.asignarPuntajeAlJugador(puntaje*multiplicador);

    }

}
