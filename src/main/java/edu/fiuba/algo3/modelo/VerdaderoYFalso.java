package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoYFalso implements Preguntas{


    private final String pregunta;
    private ArrayList<Opcion> opciones;

    public VerdaderoYFalso(String enunciado,ArrayList<Opcion> opciones) {
        pregunta = enunciado;
        this.opciones = opciones;
    }

    @Override
    public ArrayList<Opcion> opciones() {
        return opciones;
    }

    @Override
    public int asignarPuntaje(Respuesta respuesta) {
        return respuesta.cantidadDeOpcionesCorrectas();
    }

    @Override
    public String contenido() {
        return pregunta;
    }

    @Override
    public ArrayList<Opcion> opcionesCorrectas() {

        ArrayList<Opcion> correctas = new ArrayList<Opcion>();

        for (Opcion opcion : opciones){
            if (opcion.esCorrecta()) {
                correctas.add(opcion);
            }
        }

        return correctas;

    }
}
