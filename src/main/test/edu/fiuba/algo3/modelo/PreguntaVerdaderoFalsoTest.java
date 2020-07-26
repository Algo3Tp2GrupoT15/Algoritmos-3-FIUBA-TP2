package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.VerdaderoYFalso;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaVerdaderoFalsoTest {
    @Test
    public void testUnaPreguntadeVerdaderoFalsoClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        VerdaderoYFalso verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opciones);

        assertEquals(opcionCorrecta, verdaderoYFalso.opcionesCorrectas().get(0));

    }

    @Test
    public void testUnaPreguntaVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        VerdaderoYFalso verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opciones);

        Respuesta respuestaJugador1 = new Respuesta();
        Respuesta respuestaJugador2 = new Respuesta();
        respuestaJugador1.agregarOption(opcionCorrecta);
        respuestaJugador2.agregarOption(opcionIncorrecta);

        jugador1.asignarPuntaje(respuestaJugador1, verdaderoYFalso);
        jugador2.asignarPuntaje(respuestaJugador2, verdaderoYFalso);

        assertEquals(1,jugador1.puntaje());
        assertEquals(0,jugador2.puntaje());
    }
}
