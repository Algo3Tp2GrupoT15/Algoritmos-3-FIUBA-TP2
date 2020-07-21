package edu.fiuba.algo3.modelo;


import java.util.ArrayList;

public class Jugador {


    private String nombre;
    private int puntos;


    public Jugador(String nombre){

        this.nombrar(nombre);
    }

    public void nombrar(String nombre){

        this.nombre = nombre;
    }

    public void responde(VerdaderoFalso pregunta, ArrayList<Respuesta> respuestas){

        respuestas.forEach((respuesta -> respuesta.remitente(this)));

        this.puntos = pregunta.recibirRespuesta(respuestas);

    }

    public int getPuntos() {
        return puntos;
    }
}
