

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class Entrega0Prueba2{

    @Test
    public void UnaPreguntadeVerdaderoFalsoAsignaCorrectamenteLosPuntosTest(){

    Jugador jugador1 = new Jugador("lean");
    Jugador jugador2 = new Jugador("juan");

    VerdaderoFalso pregunta = new VerdaderoFalso();

    Respuesta respuestaVerdadera = new Respuesta("", Boolean.TRUE);
    Respuesta respuestaFalsa = new Respuesta("", Boolean.FALSE);

    ArrayList<Respuesta> respuestasJugador1 = new ArrayList<Respuesta>();
    ArrayList<Respuesta> respuestasJugador2 = new ArrayList<Respuesta>();
    respuestasJugador1.add(respuestaVerdadera);
    respuestasJugador2.add(respuestaFalsa);

    jugador1.responde(pregunta, respuestasJugador1);
    jugador2.responde(pregunta, respuestasJugador2);


    Assert.assertEquals(jugador1.getPuntos(), 1);
    Assert.assertEquals(jugador2.getPuntos(), 0);


    }


}
