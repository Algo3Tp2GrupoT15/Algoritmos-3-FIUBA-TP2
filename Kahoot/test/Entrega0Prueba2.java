

import org.junit.Assert;
import org.junit.Test;



public class Entrega0Prueba2{

    @Test
    public void UnaPreguntadeVerdaderoFalsoAsignaCorrectamenteLosPuntosTest(){

    Jugador jugador1 = new Jugador("lean");
    Jugador jugador2 = new Jugador("juan");

    VerdaderoFalso pregunta = new VerdaderoFalso();

    Respuesta respuestaVerdadera = new Respuesta("", Boolean.TRUE);
    Respuesta respuestaFalsa = new Respuesta("", Boolean.FALSE);


    jugador1.responde(pregunta, respuestaVerdadera);
    jugador2.responde(pregunta, respuestaFalsa);


    Assert.assertEquals(jugador1.getPuntos(), 1);
    Assert.assertEquals(jugador2.getPuntos(), 0);


    }


}
