package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoYFalsoConPenalidad extends VerdaderoYFalso {

    public VerdaderoYFalsoConPenalidad(String enunciado, ArrayList<Opcion> opciones,TipoPuntaje tipo) {

        super(enunciado, opciones, tipo);

    }


    public void asignarPuntaje(Respuesta respuesta) {

        tipo.asignarPuntaje(respuesta,this.opcionesCorrectas().size());

    }

}