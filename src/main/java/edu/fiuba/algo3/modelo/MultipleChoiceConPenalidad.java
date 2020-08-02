package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceConPenalidad extends MultipleChoice{

    public MultipleChoiceConPenalidad(String pregunta, ArrayList<Opcion> opciones,TipoPuntaje tipo) {

        super(pregunta, opciones, tipo);

    }


    public void asignarPuntaje(Respuesta respuesta) {

        tipo.asignarPuntaje(respuesta,this.opcionesCorrectas().size());

    }

}
