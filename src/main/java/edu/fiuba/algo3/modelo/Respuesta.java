package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<Opcion> opciones;

    private TipoRespuesta tipo;

    private Jugador jugador;


    public Respuesta(Jugador unJugador,TipoRespuesta unTipo) {

        opciones = new ArrayList<Opcion>();

        jugador = unJugador;

        tipo = unTipo;
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


    public void asignarPuntaje(int cantidadDeCorrectas){

        tipo.asignarPuntaje(this,cantidadDeCorrectas);

    }

}
