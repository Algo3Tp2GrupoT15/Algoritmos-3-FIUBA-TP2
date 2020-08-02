package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.TipoConPenalidad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaMultipleChoiceConPenalidadTest {

    @Test
    public void testUnaPreguntaMultipleChoiceClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){


        Opcion opcionCorrecta = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta,opcionCorrecta2,opcionIncorrecta,opcionIncorrecta2));

        TipoConPenalidad tipoConPenalidad = new TipoConPenalidad();

        MultipleChoice multipleChoiceConPenalidad = new MultipleChoice(" 2+2=..? ", opciones, tipoConPenalidad);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta2,opcionCorrecta));

        assertTrue(multipleChoiceConPenalidad.opcionesCorrectas().containsAll(opcionesCorrectas));

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

        TipoConPenalidad tipoConPenalidad = new TipoConPenalidad();

        MultipleChoice multipleChoiceConPenalidad = new MultipleChoice(" 2+2=..? ", opciones,tipoConPenalidad);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        respuestaJugador1.agregarOpcion(opcionCorrecta2);
        respuestaJugador1.agregarOpcion(opcionIncorrecta);
        respuestaJugador1.agregarOpcion(opcionIncorrecta2);

        respuestaJugador2.agregarOpcion(opcionIncorrecta);
        respuestaJugador2.agregarOpcion(opcionCorrecta);
        respuestaJugador2.agregarOpcion(opcionCorrecta2);

        multipleChoiceConPenalidad.asignarPuntaje(respuestaJugador1);
        multipleChoiceConPenalidad.asignarPuntaje(respuestaJugador2);

        assertEquals(0,jugador1.puntaje());
        assertEquals(1,jugador2.puntaje());

    }


}
