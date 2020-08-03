package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PreguntaOrderedChoiceTest {

    @Test
    public void testUnaPreguntaOrderedChoicePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){

        Opcion opcion1 = new Opcion("2",true);
        Opcion opcion2 = new Opcion("4",true);
        Opcion opcion3 = new Opcion("6",true);
        Opcion opcion4 = new Opcion("8",true);

        ArrayList<Opcion> opcionesEnOrden = new ArrayList<Opcion>(Arrays.asList(opcion1,opcion2,opcion3,opcion4));

        OrderedChoice orderedChoice = new OrderedChoice(" Ordene los numeros de forma ascendente ", opcionesEnOrden);


        assertEquals(opcionesEnOrden, orderedChoice.opcionesCorrectas());

    }

    @Test
    public void testUnaPreguntaOrderedChoiceRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcion1 = new Opcion("2",true);
        Opcion opcion2 = new Opcion("4",true);
        Opcion opcion3 = new Opcion("6",true);
        Opcion opcion4 = new Opcion("8",true);

        ArrayList<Opcion> opcionesEnOrden = new ArrayList<Opcion>(Arrays.asList(opcion1,opcion2,opcion3,opcion4));

        OrderedChoice orderedChoice = new OrderedChoice(" Ordene los numeros de forma ascendente ", opcionesEnOrden);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(opcion1);
        respuestaJugador1.agregarOpcion(opcion2);
        respuestaJugador1.agregarOpcion(opcion3);
        respuestaJugador1.agregarOpcion(opcion4);


        respuestaJugador2.agregarOpcion(opcion4);
        respuestaJugador2.agregarOpcion(opcion3);
        respuestaJugador2.agregarOpcion(opcion1);
        respuestaJugador2.agregarOpcion(opcion2);

        orderedChoice.asignarPuntaje(respuestaJugador1);
        orderedChoice.asignarPuntaje(respuestaJugador2);

        assertEquals(1,jugador1.puntaje());
        assertEquals(0,jugador2.puntaje());
    }














}
