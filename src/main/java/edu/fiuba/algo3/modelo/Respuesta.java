package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<Opcion> opciones;

    public Respuesta() {

        opciones = new ArrayList<Opcion>();
    }


    public void agregarOption(Opcion opcion) {

        opciones.add(opcion);
    }


    public int cantidadDeOpcionesCorrectas(){

        long cantidad = opciones.stream().filter(opcion -> opcion.esCorrecta()).count();

        return (int)cantidad;
    }


    public int cantidadDeOpcionesIncorrectas(){

        long cantidad = opciones.stream().filter(opcion -> !opcion.esCorrecta()).count();

        return (int)cantidad;
    }





}
