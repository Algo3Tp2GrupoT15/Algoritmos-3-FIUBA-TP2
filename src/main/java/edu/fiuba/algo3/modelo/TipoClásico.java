package edu.fiuba.algo3.modelo;

public class TipoClásico extends TipoRespuesta{

    public void asignarPuntaje(Respuesta respuesta,int cantidadDeCorrectas){

        if(cantidadDeCorrectas == respuesta.cantidadDeOpcionesCorrectas())

            respuesta.asignarPuntajeAlJugador(1);

    }

}
