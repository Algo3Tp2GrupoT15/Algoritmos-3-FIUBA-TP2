package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {

    @Test
    public void testUnaPreguntaGroupChoicePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {

        Opcion opcion1 = new Opcion("1-impar", true);
        Opcion opcion2 = new Opcion("2-par", true);
        Opcion opcion3 = new Opcion("3-impar", true);
        Opcion opcion4 = new Opcion("4-par", true);

        ArrayList<Opcion> opcionesEnGrupos = new ArrayList<Opcion>(Arrays.asList(opcion1, opcion2, opcion3, opcion4));

        TipoClásico tipoClásico = new TipoClásico();

        GroupChoice groupChoice = new GroupChoice(" Clasifique los numeros en pares e impares ", opcionesEnGrupos, tipoClásico);


        assertEquals(opcionesEnGrupos, groupChoice.opcionesCorrectas());

    }


    @Test
    public void testUnaPreguntaGroupChoiceRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcion1 = new Opcion("1-impar", true);
        Opcion opcion2 = new Opcion("2-par", true);
        Opcion opcion3 = new Opcion("3-impar", true);
        Opcion opcion4 = new Opcion("4-par", true);
        Opcion opcion5 = new Opcion("1-par", false);
        Opcion opcion6 = new Opcion("4-impar", false);

        ArrayList<Opcion> opcionesEnGrupos = new ArrayList<Opcion>(Arrays.asList(opcion1, opcion2, opcion3, opcion4));

        TipoClásico tipoClásico = new TipoClásico();

        GroupChoice groupChoice = new GroupChoice(" Clasifique los numeros en pares e impares ", opcionesEnGrupos, tipoClásico);

        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(opcion1);
        respuestaJugador1.agregarOpcion(opcion2);
        respuestaJugador1.agregarOpcion(opcion3);
        respuestaJugador1.agregarOpcion(opcion4);

        respuestaJugador2.agregarOpcion(opcion5);
        respuestaJugador2.agregarOpcion(opcion2);
        respuestaJugador2.agregarOpcion(opcion3);
        respuestaJugador2.agregarOpcion(opcion6);

        groupChoice.asignarPuntaje(respuestaJugador1);
        groupChoice.asignarPuntaje(respuestaJugador2);

        assertEquals(1, jugador1.puntaje());
        assertEquals(0, jugador2.puntaje());

    }

}