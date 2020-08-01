package edu.fiuba.algo3.modelo;

public class TipoConPenalidad extends TipoRespuesta{

    public void asignarPuntaje(Respuesta respuesta,int cantidadDeCorrectas){

        int puntaje = respuesta.cantidadDeOpcionesCorrectas() - respuesta.cantidadDeOpcionesIncorrectas();

        respuesta.asignarPuntajeAlJugador(puntaje);

    }

}
