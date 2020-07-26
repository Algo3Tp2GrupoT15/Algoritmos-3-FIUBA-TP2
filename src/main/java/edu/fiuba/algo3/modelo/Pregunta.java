package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {
    private final String texto;
    private ArrayList<Opcion> opciones;

    public Pregunta(String enunciado) {
        texto = enunciado;
        opciones = new ArrayList<Opcion>();
    }

    public void agregarOpcion(Opcion opcion) {
        opciones.add(opcion);
    }

}
