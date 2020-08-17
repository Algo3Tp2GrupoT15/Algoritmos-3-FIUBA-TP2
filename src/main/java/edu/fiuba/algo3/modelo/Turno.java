package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Turno {
    private int numeroDeJugador;
    private final ArrayList<Jugador> jugadores;

    public Turno() {
        jugadores = new ArrayList<Jugador>();
        this.numeroDeJugador = 0;
    }

    public void siguiente() {
        numeroDeJugador +=1;
    }

    public Jugador jugador() {
        return jugadores.get(numeroDeJugador);
    }

    public void agregarJugador(String nombre) {
        jugadores.add(new Jugador(nombre));
    }

    public void resetearTurno() {
        numeroDeJugador = 0;
    }

    public ArrayList<Jugador> jugadores() {
        return jugadores;
    }
}
