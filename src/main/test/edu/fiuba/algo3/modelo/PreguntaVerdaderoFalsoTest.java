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

        TipoClásico tipoClásico = new TipoClásico();

        VerdaderoYFalso verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opciones, tipoClásico);

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

        TipoClásico tipoClásico = new TipoClásico();

        VerdaderoYFalso verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opciones,tipoClásico);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        respuestaJugador2.agregarOpcion(opcionIncorrecta);

        verdaderoYFalso.asignarPuntaje(respuestaJugador1);
        verdaderoYFalso.asignarPuntaje(respuestaJugador2);

        assertEquals(1,jugador1.puntaje());
        assertEquals(0,jugador2.puntaje());
    }
}
