package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceParcial extends MultipleChoice{


    public MultipleChoiceParcial(String pregunta, ArrayList<Opcion> opciones) {
        super(pregunta, opciones);
    }

    public int asignarPuntaje(Respuesta respuesta) {

        int puntaje = 0;

        if (respuesta.cantidadDeOpcionesIncorrectas() == 0) {

            puntaje += respuesta.cantidadDeOpcionesCorrectas();

        }

        return puntaje;
    }

}
