package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.MultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaMultipleChoiceConPuntajeParcialTest {

    @Test
    public void testUnaPreguntaMultipleChoiceConPuntajeParcialPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){

        Opcion opcionCorrecta = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta,opcionCorrecta2,opcionIncorrecta,opcionIncorrecta2));

        TipoParcial tipoParcial = new TipoParcial();

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(" 2+2=..? ", opciones, tipoParcial);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta2,opcionCorrecta));


        assertTrue(multipleChoiceParcial.opcionesCorrectas().containsAll(opcionesCorrectas));

    }

    @Test
    public void testUnaPreguntaMultipleChoiceConPuntajeParcialRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcionCorrecta = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta,opcionCorrecta2,opcionIncorrecta,opcionIncorrecta2));

        TipoParcial tipoParcial = new TipoParcial();

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(" 2+2=..? ", opciones,tipoParcial);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        respuestaJugador1.agregarOpcion(opcionCorrecta2);
        respuestaJugador2.agregarOpcion(opcionIncorrecta);
        respuestaJugador2.agregarOpcion(opcionCorrecta2);

        multipleChoiceParcial.asignarPuntaje(respuestaJugador1);
        multipleChoiceParcial.asignarPuntaje(respuestaJugador2);

        assertEquals(2,jugador1.puntaje());
        assertEquals(0,jugador2.puntaje());

    }

}
