package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.VerdaderoYFalsoConPenalidad;
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
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        respuestaJugador2.agregarOpcion(opcionIncorrecta);

        respuestaJugador1.agregarJugador(jugador1);
        respuestaJugador2.agregarJugador(jugador2);

        verdaderoYFalsoConPenalidad.asignarPuntaje(respuestaJugador1);
        verdaderoYFalsoConPenalidad.asignarPuntaje(respuestaJugador2);

        assertEquals(1,jugador1.puntaje());
        assertEquals(-1,jugador2.puntaje());
    }







}
