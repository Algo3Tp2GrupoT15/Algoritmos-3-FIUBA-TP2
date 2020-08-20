package edu.fiuba.algo3.modelo.kahootModel;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KahootModelTest {
    @Test
    public void cargarUnJugadorYPedirElJugadorDeTurnoDevuelveElJugadorTest() {
        Jugador jugador;
        KahootModel kahoot = new KahootModel();
        kahoot.cargarJugador("jugador");
        jugador = kahoot.jugadorDeTurno();
        assertEquals("jugador",jugador.nombre());
    }

    @Test
    public void cargarDosJugadoresIrAlSiguienteTurnoYPedirElJugadorDeTurnoDevuelveElSegundoJugadorTest() {
        Jugador jugador;
        KahootModel kahoot = new KahootModel();
        kahoot.cargarJugador("jugador1");
        kahoot.cargarJugador("jugador2");
        kahoot.siguienteJugador();
        jugador = kahoot.jugadorDeTurno();
        assertEquals("jugador2",jugador.nombre());
    }

    @Test
    public void proximaPreguntaDeTurnoReiniciaElTurnoPedirElJugadorDeTurnoDevuelveElPrimerJugadorTest() {
        Jugador jugador;
        KahootModel kahoot = new KahootModel();
        kahoot.cargarJugador("jugador1");
        kahoot.cargarJugador("jugador2");
        kahoot.siguienteJugador();
        kahoot.proximaPreguntaDeTurno();
        jugador = kahoot.jugadorDeTurno();
        assertEquals("jugador1",jugador.nombre());
    }

    @Test
    public void mostrarContenidoDeTurnoTest() {
        KahootModel kahoot = new KahootModel();
        kahoot.leerPreguntas();
        assertEquals("El cielo es azul",kahoot.mostrarPreguntaDeTurno());
    }

    @Test
    public void proximaPreguntaDeTurnoAvanzaALaSiguientePregunta() {
        KahootModel kahoot = new KahootModel();
        kahoot.leerPreguntas();
        kahoot.proximaPreguntaDeTurno();
        assertEquals("2+2=..?",kahoot.mostrarPreguntaDeTurno());
    }

    @Test
    public void mostrarOpcionesDeTurnoTest() {
        KahootModel kahoot = new KahootModel();
        kahoot.leerPreguntas();
        assertEquals("Verdadero",kahoot.mostrarOpcionesDeTurno().get(0).contenido());
        assertEquals("Falso",kahoot.mostrarOpcionesDeTurno().get(1).contenido());
    }

    @Test
    public void alAvanzarConProximaPreguntaDeTurnoAvanzaOpcionesDeTurnoTest() {
        KahootModel kahoot = new KahootModel();
        kahoot.leerPreguntas();
        kahoot.proximaPreguntaDeTurno();

        assertEquals("4",kahoot.mostrarOpcionesDeTurno().get(0).contenido());
        assertEquals("2^2",kahoot.mostrarOpcionesDeTurno().get(1).contenido());
        assertEquals("8",kahoot.mostrarOpcionesDeTurno().get(2).contenido());
        assertEquals("Pez",kahoot.mostrarOpcionesDeTurno().get(3).contenido());
    }

    @Test
    public void cargarRespuestasDelTurnoTest() {
        KahootModel kahoot = new KahootModel();
        kahoot.cargarJugador("jugador1");
        kahoot.cargarJugador("jugador2");
        kahoot.leerPreguntas();
        kahoot.proximaPreguntaDeTurno();

        Respuesta respuestaJugador1 = new Respuesta(kahoot.jugadorDeTurno());
        respuestaJugador1.agregarOpcion(kahoot.mostrarOpcionesDeTurno().get(2));
        respuestaJugador1.agregarOpcion(kahoot.mostrarOpcionesDeTurno().get(3));
        kahoot.cargarRespuestas(respuestaJugador1);

        kahoot.calcularPuntosDelTurno();
        assertEquals(0,kahoot.jugadorDeTurno().puntaje());

        kahoot.siguienteJugador();

        Respuesta respuestaJugador2 = new Respuesta(kahoot.jugadorDeTurno());
        respuestaJugador2.agregarOpcion(kahoot.mostrarOpcionesDeTurno().get(0));
        respuestaJugador2.agregarOpcion(kahoot.mostrarOpcionesDeTurno().get(1));
        kahoot.cargarRespuestas(respuestaJugador2);

        kahoot.calcularPuntosDelTurno();
        assertEquals(1,kahoot.jugadorDeTurno().puntaje());
    }
}
