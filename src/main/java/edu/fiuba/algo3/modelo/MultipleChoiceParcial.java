package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceParcial extends MultipleChoice{

    public MultipleChoiceParcial(String pregunta, ArrayList<Opcion> opciones) {

        super(pregunta, opciones);

    }


    public void asignarPuntaje(Respuesta respuesta) {

        respuesta.asignarPuntajeParcial();

    }


}
