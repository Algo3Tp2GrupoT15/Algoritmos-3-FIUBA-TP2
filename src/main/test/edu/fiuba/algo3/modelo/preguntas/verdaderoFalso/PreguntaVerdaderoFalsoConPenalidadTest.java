package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalsoConPenalidad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoConPenalidadTest {


    @Test
    public void testUnaPreguntadeVerdaderoFalsoConPenalidadPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        VerdaderoYFalsoConPenalidad verdaderoYFalsoConPenalidad = new VerdaderoYFalsoConPenalidad("El cielo es azul", opciones);

        assertEquals(opcionCorrecta, verdaderoYFalsoConPenalidad.opcionesCorrectas().get(0));
    }

    @Test
    public void testUnaPreguntaVerdaderoFalsoConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        VerdaderoYFalsoConPenalidad verdaderoYFalsoConPenalidad = new VerdaderoYFalsoConPenalidad("El cielo es azul", opciones);

        Respuesta respuestaJugador1 = new Respuesta();
        Respuesta respuestaJugador2 = new Respuesta();
        respuestaJugador1.agregarOption(opcionCorrecta);
        respuestaJugador2.agregarOption(opcionIncorrecta);

        jugador1.asignarPuntaje(respuestaJugador1, verdaderoYFalsoConPenalidad);
        jugador2.asignarPuntaje(respuestaJugador2, verdaderoYFalsoConPenalidad);

        assertEquals(1,jugador1.puntaje());
        assertEquals(-1,jugador2.puntaje());
    }







}
