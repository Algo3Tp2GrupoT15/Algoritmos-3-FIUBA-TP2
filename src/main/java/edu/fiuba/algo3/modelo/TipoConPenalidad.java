package edu.fiuba.algo3.modelo;

public class TipoConPenalidad extends TipoPuntaje {

    public void asignarPuntaje(Respuesta respuesta,int cantidadDeCorrectas){

        int puntaje = respuesta.cantidadDeOpcionesCorrectas() - respuesta.cantidadDeOpcionesIncorrectas();

        respuesta.asignarPuntajeAlJugador(puntaje);

    }

}
