package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

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
    public void modificarPuntos(ArrayList<Jugador> jugadores) {


        Jugador jugador1 = jugadores.get(0) ;
        Jugador jugador2 = jugadores.get(1) ;

        int puntosganasdosEstaRondaJugador1=jugador1.getUltimoPuntajeAgregado();
        int puntosganasdosEstaRondaJugador2=jugador2.getUltimoPuntajeAgregado();


        if (activado){
            if (puntosganasdosEstaRondaJugador1!= 0 & puntosganasdosEstaRondaJugador2!= 0) {

                jugador1.agregarPuntaje(-(puntosganasdosEstaRondaJugador1));
                jugador2.agregarPuntaje(-(puntosganasdosEstaRondaJugador2));
                puntosganasdosEstaRondaJugador1 = 0;
                puntosganasdosEstaRondaJugador2 = 0;
            }

            jugador1.agregarPuntaje((puntosganasdosEstaRondaJugador1*multiplicador)-puntosganasdosEstaRondaJugador1);
            jugador2.agregarPuntaje((puntosganasdosEstaRondaJugador2*multiplicador)-puntosganasdosEstaRondaJugador2);

            activado = false;
            multiplicador = 1;
        }


    }

}
