package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.TipoClásico;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {

    @Test
    public void testExclusividadAsignaCorrectamenteLosPuntos() {

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

        Exclusividad exclusividad = new Exclusividad();
        exclusividad.activar(2);
        exclusividad.modificarPuntos(jugador1,jugador2);

        assertEquals(2,jugador1.puntaje());
        assertEquals(0,jugador2.puntaje());

    }
    @Test
    public void testExclusividadRestaCorrectamenteLosPuntos() {

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
        respuestaJugador2.agregarOpcion(opcionCorrecta);

        verdaderoYFalso.asignarPuntaje(respuestaJugador1);
        verdaderoYFalso.asignarPuntaje(respuestaJugador2);

        Exclusividad exclusividad = new Exclusividad();
        exclusividad.activar(2);
        exclusividad.modificarPuntos(jugador1,jugador2);

        assertEquals(0,jugador1.puntaje());
        assertEquals(0,jugador2.puntaje());

    }

    @Test
    public void testExclusividadNoDeberiaFuncionarSiUsosEs0() {

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
        respuestaJugador2.agregarOpcion(opcionCorrecta);

        verdaderoYFalso.asignarPuntaje(respuestaJugador1);
        verdaderoYFalso.asignarPuntaje(respuestaJugador2);

        Exclusividad exclusividad = new Exclusividad();
        exclusividad.activar(0);
        exclusividad.modificarPuntos(jugador1,jugador2);

        assertEquals(1,jugador1.puntaje());
        assertEquals(1,jugador2.puntaje());

    }

    @Test
    public void testExclusividadSeActivaDosVecesYAsignaCorrectamenteElCuadrupleDeLosPuntos() {

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

        Exclusividad exclusividad = new Exclusividad();
        exclusividad.activar(2);
        exclusividad.activar(2);

        exclusividad.modificarPuntos(jugador1,jugador2);


        assertEquals(4,jugador1.puntaje());
        assertEquals(0,jugador2.puntaje());

    }

}
