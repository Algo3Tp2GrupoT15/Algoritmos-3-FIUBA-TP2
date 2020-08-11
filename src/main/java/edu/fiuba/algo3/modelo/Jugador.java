package edu.fiuba.algo3.modelo;

public class Jugador {

    private int puntaje;
    private String nombre;
    private int multiplicador;

    public Jugador() {
        puntaje = 0;
        multiplicador = 1;
    }

    public Jugador(String nombre) {

        this.nombre = nombre;
        puntaje = 0;
        multiplicador = 1;
    }

    public void agregarPuntaje(int unPuntaje) {

        puntaje += (unPuntaje * multiplicador);

    }

    public void agregarNombre(String nombre){

        this.nombre = nombre;
    }

    public int puntaje() {

        return puntaje;

    }

    public void asignarMultiplicador(int factor){

        multiplicador = factor;

    }

}
