package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta;

public class TipoConPenalidad implements TipoPuntaje {


    private String tipo = "Con Penalidad";

    public void asignarPuntaje(Respuesta respuesta, int cantidadDeCorrectas){

        int puntaje = respuesta.cantidadDeOpcionesCorrectas() - respuesta.cantidadDeOpcionesIncorrectas();

        respuesta.asignarPuntajeAlJugador(puntaje);

    }

    @Override
    public boolean hayExclusividad() {
        return false;
    }

    @Override
    public boolean hayMultiplicadores() {
        return true;
    }

    @Override
    public String tipoDePuntaje() {
        return tipo;
    }

}
