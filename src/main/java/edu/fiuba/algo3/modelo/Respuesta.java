package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {
    private ArrayList<Opcion> opciones;

    public Respuesta() {
        opciones = new ArrayList<Opcion>();
    }

    public void agregarOption(Opcion opcion) {
        opciones.add(opcion);
    }

    public boolean esCorrecta() {
        Boolean valor = true;
        for (Opcion opcion: opciones
             ) {
            if (opcion.esCorrecta() == false) {
                valor = false;
            }
        }
        return valor;
    }
}
