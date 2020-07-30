package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<Opcion> opciones;

    private Jugador jugador;

    public Respuesta() {

        opciones = new ArrayList<Opcion>();
    }


    public void agregarOpcion(Opcion opcion) {

        opciones.add(opcion);
    }

    public void agregarJugador(Jugador unJugador) {

        jugador=unJugador;
    }


    public int cantidadDeOpcionesCorrectas(){

        long cantidad = opciones.stream().filter(opcion -> opcion.esCorrecta()).count();

        return (int)cantidad;
    }


    public int cantidadDeOpcionesIncorrectas(){

        long cantidad = opciones.stream().filter(opcion -> !opcion.esCorrecta()).count();

        return (int)cantidad;
    }


    public void asignarPuntajeClasico(int cantidadDeCorrectas){

        if(cantidadDeCorrectas == this.cantidadDeOpcionesCorrectas()){

            jugador.agregarPuntaje(1);

        }

    }


    public void asignarPuntajeConPenalidad(){

        int puntaje = this.cantidadDeOpcionesCorrectas() - this.cantidadDeOpcionesIncorrectas();

        jugador.agregarPuntaje(puntaje);
    }


    public void asignarPuntajeParcial(){

        if (this.cantidadDeOpcionesIncorrectas() == 0) {

            jugador.agregarPuntaje(this.cantidadDeOpcionesCorrectas());

        }
    }


}
