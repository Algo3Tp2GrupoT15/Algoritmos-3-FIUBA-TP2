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

        int cantidad = 0;
        for (Opcion opcion : opciones){
            if (opcion.esCorrecta()) {
                cantidad += 1;
            }
        }

        return cantidad;
    }



    public int cantidadDeOpcionesIncorrectas(){

        int cantidad = 0;
        for (Opcion opcion : opciones){
            if (!opcion.esCorrecta()) {
                cantidad += 1;
            }
        }

        return cantidad;
    }





}
