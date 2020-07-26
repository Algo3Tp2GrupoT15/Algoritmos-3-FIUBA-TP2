package edu.fiuba.algo3.modelo;

public class Jugador {
    private int puntaje;

    public Jugador() {
        puntaje = 0;
    }

    public void asignarPuntaje(Respuesta respuesta, Preguntas Pregunta) {

        puntaje = Pregunta.asignarPuntaje(respuesta);


    }

    public int puntaje() {

        return puntaje;

    }
}
