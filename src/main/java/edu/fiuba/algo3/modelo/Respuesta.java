package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<Opcion> opciones;

    private final Jugador jugador;


    public Respuesta(Jugador unJugador) {

        opciones = new ArrayList<>();

        jugador = unJugador;

    }


    public void agregarOpcion(Opcion opcion) {

        opciones.add(opcion);
    }


    public void asignarPuntajeAlJugador(int puntaje) {

        jugador.agregarPuntaje(puntaje);
    }


    public int cantidadDeOpcionesCorrectas(){

        long cantidad;
        cantidad = opciones.stream().filter(Opcion::esCorrecta).count();

        return (int) cantidad;
    }


    public int cantidadDeOpcionesIncorrectas(){

        long cantidad = opciones.stream().filter(opcion -> !opcion.esCorrecta()).count();

        return (int)cantidad;
    }


    public ArrayList<Opcion> opciones() {
        return opciones;
    }

    public int puntajeDelJugador(){

        return this.jugador.puntaje();

    }

    public void eliminarOpciones(){

        opciones = new ArrayList<>();

    }

}
