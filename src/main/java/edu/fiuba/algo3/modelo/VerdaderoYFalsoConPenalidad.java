package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoYFalsoConPenalidad extends VerdaderoYFalso{


    public VerdaderoYFalsoConPenalidad(String enunciado, ArrayList<Opcion> opciones) {
        super(enunciado, opciones);
    }

    public int asignarPuntaje(Respuesta respuesta) {

        return (respuesta.cantidadDeOpcionesCorrectas() - respuesta.cantidadDeOpcionesIncorrectas());
    }

}