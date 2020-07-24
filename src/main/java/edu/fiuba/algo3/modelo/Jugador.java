package edu.fiuba.algo3.modelo;

public class Jugador {
    private int puntaje;

    public Jugador() {
        puntaje = 0;
    }

    public void asignarPuntaje(Respuesta respuesta) {
        if (respuesta.esCorrecta()) {
            puntaje = puntaje + 1;
        }
    }

    public int puntaje() {
        return puntaje;
    }
}
