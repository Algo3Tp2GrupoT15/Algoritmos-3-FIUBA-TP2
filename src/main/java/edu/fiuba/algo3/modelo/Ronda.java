package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Preguntas;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;

public class Ronda {
    private int ronda;
    private Preguntas pregunta;
    private Respuesta respuestaJugador1;
    private Respuesta respuestaJugador2;

    public Ronda(Jugador jugador1, Jugador jugador2) {
        respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador2 = new Respuesta(jugador2);
        ronda = 1;
    }

    public int actual() {
        return ronda;
    }

    public void jugar() {
        pregunta.asignarPuntaje(respuestaJugador1);
        pregunta.asignarPuntaje(respuestaJugador2);
        ronda = ronda + 1;
    }

    public void agregarPregunta(Preguntas verdaderoYFalso) {
        pregunta = verdaderoYFalso;
    }

    public void agregarRespuestaJugador1(Respuesta respuestaJugador1) {
        this.respuestaJugador1 = respuestaJugador1;
    }

    public void agregarRespuestaJugador2(Respuesta respuestaJugador2) {
        this.respuestaJugador2 = respuestaJugador2;
    }
}