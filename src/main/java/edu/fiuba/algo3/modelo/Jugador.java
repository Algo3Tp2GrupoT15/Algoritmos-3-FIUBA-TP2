package edu.fiuba.algo3.modelo;

public class Jugador {
    private int puntaje;
    private String nombre;

    public Jugador() {
        puntaje = 0;
    }

    public void asignarPuntaje(Respuesta respuesta, Preguntas Pregunta) {

        puntaje = Pregunta.asignarPuntaje(respuesta);


    }

    public void asignarNombre(String nombre){

        this.nombre = nombre;
    }

    public int puntaje() {

        return puntaje;

    }
}
