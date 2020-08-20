package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta;

public class TipoClasico implements TipoPuntaje {


    private String tipo = "Clasico";

    public void asignarPuntaje(Respuesta respuesta, int cantidadDeCorrectas){

        if(cantidadDeCorrectas == respuesta.cantidadDeOpcionesCorrectas())

            respuesta.asignarPuntajeAlJugador(1);

    }

    @Override
    public boolean hayExclusividad() {
        return true;
    }

    @Override
    public boolean hayMultiplicadores() {
        return false;
    }

    @Override
    public String tipoDePuntaje() {
        return tipo;
    }

}
