package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.TipoConPenalidad;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;
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

        TipoConPenalidad tipoConPenalidad = new TipoConPenalidad();

        VerdaderoYFalso verdaderoYFalsoConPenalidad = new VerdaderoYFalso("El cielo es azul", opciones, tipoConPenalidad);

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

        TipoConPenalidad tipoConPenalidad = new TipoConPenalidad();

        VerdaderoYFalso verdaderoYFalsoConPenalidad = new VerdaderoYFalso("El cielo es azul", opciones,tipoConPenalidad);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        respuestaJugador2.agregarOpcion(opcionIncorrecta);

        verdaderoYFalsoConPenalidad.asignarPuntaje(respuestaJugador1);
        verdaderoYFalsoConPenalidad.asignarPuntaje(respuestaJugador2);

        assertEquals(1,jugador1.puntaje());
        assertEquals(-1,jugador2.puntaje());
    }

    @Test
    public void testUnaPreguntaVerdaderoFalsoConPenalidadAsignaPuntosALosJugadoresQueRespondieronCorrectamenteUsandoMultiplicador() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        TipoConPenalidad tipoConPenalidad = new TipoConPenalidad();

        VerdaderoYFalso verdaderoYFalsoConPenalidad = new VerdaderoYFalso("El cielo es azul", opciones,tipoConPenalidad);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        respuestaJugador2.agregarOpcion(opcionIncorrecta);


        jugador1.multiplicadorX3();
        verdaderoYFalsoConPenalidad.asignarPuntaje(respuestaJugador1);

        jugador2.multiplicadorX2();
        verdaderoYFalsoConPenalidad.asignarPuntaje(respuestaJugador2);

        assertEquals(3,jugador1.puntaje());
        assertEquals(-2,jugador2.puntaje());
    }


}
