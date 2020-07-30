package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceConPenalidad extends MultipleChoice{

    public MultipleChoiceConPenalidad(String pregunta, ArrayList<Opcion> opciones) {

        super(pregunta, opciones);

    }


    public void asignarPuntaje(Respuesta respuesta) {

        respuesta.asignarPuntajeConPenalidad();

    }

}
