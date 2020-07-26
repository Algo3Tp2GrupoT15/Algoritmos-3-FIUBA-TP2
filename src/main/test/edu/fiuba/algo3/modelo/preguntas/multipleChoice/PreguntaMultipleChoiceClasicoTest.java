package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicoTest {

    @Test
    public void testUnaPreguntaMultipleChoiceClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){


        Opcion opcionCorrecta = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta,opcionCorrecta2,opcionIncorrecta,opcionIncorrecta2));

        MultipleChoice multipleChoice = new MultipleChoice(" 2+2=..? ", opciones);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta,opcionCorrecta2));

        assertEquals(opcionesCorrectas, multipleChoice.opcionesCorrectas());
    }

    @Test
    public void testUnaPreguntaMultipleChoiceClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcionCorrecta = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta,opcionCorrecta2,opcionIncorrecta,opcionIncorrecta2));

        MultipleChoice multipleChoice = new MultipleChoice(" 2+2=..? ", opciones);

        Respuesta respuestaJugador1 = new Respuesta();
        Respuesta respuestaJugador2 = new Respuesta();
        respuestaJugador1.agregarOption(opcionCorrecta);
        respuestaJugador1.agregarOption(opcionCorrecta2);
        respuestaJugador2.agregarOption(opcionIncorrecta);
        respuestaJugador2.agregarOption(opcionCorrecta2);

        jugador1.asignarPuntaje(respuestaJugador1, multipleChoice);
        jugador2.asignarPuntaje(respuestaJugador2, multipleChoice);

        assertEquals(1,jugador1.puntaje());
        assertEquals(0,jugador2.puntaje());

    }
}







