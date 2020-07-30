package edu.fiuba.algo3.modelo;

public class Jugador {
    private int puntaje;
    private String nombre;

    public Jugador() {
        puntaje = 0;
    }

    public void agregarPuntaje(int unPuntaje) {

        puntaje = unPuntaje;

    }

    public void agregarNombre(String nombre){

        this.nombre = nombre;
    }

    public int puntaje() {

        return puntaje;

    }
}
