package edu.fiuba.algo3.modelo;

public class TipoParcial extends TipoPuntaje {

    public void asignarPuntaje(Respuesta respuesta, int cantidadDeCorrectas) {

        if (respuesta.cantidadDeOpcionesIncorrectas() == 0)

            respuesta.asignarPuntajeAlJugador(respuesta.cantidadDeOpcionesCorrectas());

    }

}
