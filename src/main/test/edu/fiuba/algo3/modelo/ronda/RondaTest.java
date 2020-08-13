package edu.fiuba.algo3.modelo.ronda;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.preguntas.TipoClasico;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {
    @Test
    public void alJugarUnaRondaAvanzaALaSiguienteTest() {
        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        TipoClasico tipoClásico = new TipoClasico();
        VerdaderoYFalso verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opciones, tipoClásico);

        Jugador jugador1 = new Jugador("jugador1");
        Jugador jugador2 = new Jugador("jugador2");
        Ronda ronda = new Ronda(jugador1, jugador2);
        ronda.agregarPregunta(verdaderoYFalso);
        assertEquals(1,ronda.actual());
        ronda.jugar();
        assertEquals(2,ronda.actual());
        ronda.jugar();
        assertEquals(3,ronda.actual());
    }

    @Test
    void seJuegaUnaRondaConPreguntaVerdaderoFalsoClasicoJugador1RespondeBienYJugador2RespondeMal() {
        Jugador jugador1 = new Jugador("jugador1");
        Jugador jugador2 = new Jugador("jugador2");
        Ronda ronda = new Ronda(jugador1, jugador2);

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        TipoClasico tipoClásico = new TipoClasico();
        VerdaderoYFalso verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opciones, tipoClásico);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        respuestaJugador2.agregarOpcion(opcionIncorrecta);

        ronda.agregarPregunta(verdaderoYFalso);
        ronda.agregarRespuestaJugador1(respuestaJugador1);
        ronda.agregarRespuestaJugador2(respuestaJugador2);
        ronda.jugar();
        assertEquals(1, jugador1.puntaje());
        assertEquals(0, jugador2.puntaje());
    }
}