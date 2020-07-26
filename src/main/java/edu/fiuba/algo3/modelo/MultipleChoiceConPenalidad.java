package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceConPenalidad extends MultipleChoice{

    public MultipleChoiceConPenalidad(String pregunta, ArrayList<Opcion> opciones) {
        super(pregunta, opciones);
    }

    public int asignarPuntaje(Respuesta respuesta) {

        return (respuesta.cantidadDeOpcionesCorrectas() - respuesta.cantidadDeOpcionesIncorrectas());


    }

}
