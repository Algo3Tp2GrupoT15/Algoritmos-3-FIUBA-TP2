package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta;

public class TipoParcial implements TipoPuntaje {


    private String tipo = "Parcial";



    public void asignarPuntaje(Respuesta respuesta, int cantidadDeCorrectas) {

        if (respuesta.cantidadDeOpcionesIncorrectas() == 0)

            respuesta.asignarPuntajeAlJugador(respuesta.cantidadDeOpcionesCorrectas());

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
