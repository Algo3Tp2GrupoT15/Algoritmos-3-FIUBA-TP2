package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import static java.util.stream.Collectors.toCollection;

public class MultipleChoice implements Preguntas{

    private final String texto;
    private ArrayList<Opcion> opciones;

    public MultipleChoice(String pregunta, ArrayList<Opcion> opciones){

        this.opciones = opciones;
        this.texto = pregunta;

    }


    @Override
    public ArrayList<Opcion> opciones() {

        return opciones;

    }


    @Override
    public void asignarPuntaje(Respuesta respuesta) {

        respuesta.asignarPuntaje(this.opcionesCorrectas().size());

    }


    @Override
    public String contenido() {

        return texto;

    }


    @Override
    public ArrayList<Opcion> opcionesCorrectas() {

        ArrayList<Opcion> correctas;

        correctas = opciones.stream().filter(opcion -> opcion.esCorrecta()).collect(toCollection(ArrayList::new));

        return correctas;

    }
}
