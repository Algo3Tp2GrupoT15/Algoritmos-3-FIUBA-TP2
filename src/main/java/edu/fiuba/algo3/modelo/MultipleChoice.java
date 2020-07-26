package edu.fiuba.algo3.modelo;


import java.util.ArrayList;

public class MultipleChoice implements Preguntas{

    private final String pregunta;
    private ArrayList<Opcion> opciones;

    public MultipleChoice(String pregunta, ArrayList<Opcion> opciones){

        this.opciones = opciones;
        this.pregunta = pregunta;

    }


    @Override
    public ArrayList<Opcion> opciones() {
        return opciones;
    }

    @Override
    public int asignarPuntaje(Respuesta respuesta) {

        int puntaje = 0;
        int opcionesCorrectas = respuesta.cantidadDeOpcionesCorrectas();


        if(this.opcionesCorrectas().size() == opcionesCorrectas){
            puntaje += 1;
        }

        return puntaje;
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
