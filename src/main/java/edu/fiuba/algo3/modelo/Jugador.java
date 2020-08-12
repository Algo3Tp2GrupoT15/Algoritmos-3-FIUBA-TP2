package edu.fiuba.algo3.modelo;

public class Jugador {

    private int puntaje;
    private String nombre;
    private int multiplicador;
    private int ultimoPuntajeAgregado;

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
        ultimoPuntajeAgregado = unPuntaje;
        multiplicador = 1;

    }

    public void agregarNombre(String nombre){

        this.nombre = nombre;
    }
    public String  nombre(){

        return this.nombre;
    }

    public int puntaje() {

        return puntaje;

    }

    public void asignarMultiplicador(int factor){

        multiplicador = factor;
    }

    public int getUltimoPuntajeAgregado(){
        return ultimoPuntajeAgregado;
    }
}
