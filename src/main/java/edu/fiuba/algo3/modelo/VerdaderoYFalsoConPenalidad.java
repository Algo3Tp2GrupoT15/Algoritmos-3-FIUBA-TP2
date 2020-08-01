package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoYFalsoConPenalidad extends VerdaderoYFalso {

    public VerdaderoYFalsoConPenalidad(String enunciado, ArrayList<Opcion> opciones) {

        super(enunciado, opciones);

    }


    public void asignarPuntaje(Respuesta respuesta) {

        respuesta.asignarPuntaje(this.opcionesCorrectas().size());

    }

}