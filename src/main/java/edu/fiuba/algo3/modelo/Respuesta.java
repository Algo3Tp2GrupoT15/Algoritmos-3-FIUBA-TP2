package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<Opcion> opciones;

    private Jugador jugador;


    public Respuesta(Jugador unJugador) {

        opciones = new ArrayList<Opcion>();

        jugador = unJugador;

    }


    public void agregarOpcion(Opcion opcion) {

        opciones.add(opcion);
    }


    public void asignarPuntajeAlJugador(int puntaje) {

        jugador.agregarPuntaje(puntaje);
    }


    public int cantidadDeOpcionesCorrectas(){

        long cantidad = opciones.stream().filter(opcion -> opcion.esCorrecta()).count();

        return (int)cantidad;
    }


    public int cantidadDeOpcionesIncorrectas(){

        long cantidad = opciones.stream().filter(opcion -> !opcion.esCorrecta()).count();

        return (int)cantidad;
    }


    public ArrayList<Opcion> opciones() {
        return opciones;
    }
}
