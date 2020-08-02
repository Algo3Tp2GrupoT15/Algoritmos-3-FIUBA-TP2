package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.MultipleChoice;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PreguntaMultipleChoiceClasicoTest {

    @Test
    public void testUnaPreguntaMultipleChoiceClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){


        Opcion opcionCorrecta = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta,opcionCorrecta2,opcionIncorrecta,opcionIncorrecta2));

        TipoClásico tipoClásico = new TipoClásico();

        MultipleChoice multipleChoice = new MultipleChoice(" 2+2=..? ", opciones, tipoClásico);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta2,opcionCorrecta));

        assertTrue(multipleChoice.opcionesCorrectas().containsAll(opcionesCorrectas));

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

        TipoClásico tipoClásico = new TipoClásico();

        MultipleChoice multipleChoice = new MultipleChoice(" 2+2=..? ", opciones,tipoClásico);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        respuestaJugador1.agregarOpcion(opcionCorrecta2);
        respuestaJugador2.agregarOpcion(opcionIncorrecta);
        respuestaJugador2.agregarOpcion(opcionCorrecta2);

        multipleChoice.asignarPuntaje(respuestaJugador1);
        multipleChoice.asignarPuntaje(respuestaJugador2);

        assertEquals(1,jugador1.puntaje());
        assertEquals(0,jugador2.puntaje());

    }
}







