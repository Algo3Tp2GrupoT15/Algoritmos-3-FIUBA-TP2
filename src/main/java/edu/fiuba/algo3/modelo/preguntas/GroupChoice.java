package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class GroupChoice implements Preguntas{


    private final String texto;
    private ArrayList<Opcion> opciones;


    public GroupChoice(String enunciado,ArrayList<Opcion> opciones) {

        this.texto = enunciado;
        this.opciones = opciones;

    }

    @Override
    public ArrayList<Opcion> opciones() {
        return opciones;
    }

    @Override
    public void asignarPuntaje(Respuesta respuesta) {


    }

    @Override
    public String contenido() {
        return texto;
    }

    @Override
    public ArrayList<Opcion> opcionesCorrectas() {
        return null;
    }
}
