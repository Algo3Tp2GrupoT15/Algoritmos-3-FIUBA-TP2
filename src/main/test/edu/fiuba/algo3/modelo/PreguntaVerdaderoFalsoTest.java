package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaVerdaderoFalsoTest {
    @Test
    public void testUnaPreguntadeVerdaderoFalsoClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {
        Pregunta pregunta = new Pregunta("El cielo es azul");
        Opcion opcion1 = new Opcion("verdadero",true);
        Opcion opcion2 = new Opcion("falso",false);
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        Respuesta respuesta = new Respuesta();
        respuesta.agregarOpcion(opcion1);
        assertTrue(respuesta.esCorrecta());
    }

    @Test
    public void testUnaPreguntaVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Pregunta pregunta = new Pregunta("El cielo es azul");
        Opcion opcion1 = new Opcion("verdadero",true);
        Opcion opcion2 = new Opcion("falso",false);
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        Respuesta respuestaJugador1 = new Respuesta();
        Respuesta respuestaJugador2 = new Respuesta();
        respuestaJugador1.agregarOpcion(opcion1);
        respuestaJugador2.agregarOpcion(opcion2);
        jugador1.asignarPuntaje(respuestaJugador1);
        jugador2.asignarPuntaje(respuestaJugador2);
        assertEquals(1,jugador1.puntaje());
        assertEquals(0,jugador2.puntaje());
    }
}
