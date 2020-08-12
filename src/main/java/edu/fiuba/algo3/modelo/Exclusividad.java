package edu.fiuba.algo3.modelo;

public class Exclusividad {


    private boolean activado;
    private int multiplicador;

    public Exclusividad() {


        activado = false;
        multiplicador = 1;
    }

    public void activar(int usos) {
        if(usos!=0){

            activado = true;
            multiplicador *= 2;

        }

    }
    public void modificarPuntos(Jugador jugador1, Jugador jugador2) {

        int puntosJugador1=jugador1.getUltimoPuntajeAgregado();

        int puntosJugador2=jugador2.getUltimoPuntajeAgregado();


        if (activado){
            if (puntosJugador1!= 0 & puntosJugador2!= 0) {

                jugador1.agregarPuntaje(-(puntosJugador2));
                jugador2.agregarPuntaje(-(puntosJugador2));
                puntosJugador1 = 0;
                puntosJugador2 = 0;
            }

            jugador1.agregarPuntaje((puntosJugador1*multiplicador)-puntosJugador1);
            jugador2.agregarPuntaje((puntosJugador2*multiplicador)-puntosJugador2);

            activado = false;
            multiplicador = 1;
        }


    }

}
