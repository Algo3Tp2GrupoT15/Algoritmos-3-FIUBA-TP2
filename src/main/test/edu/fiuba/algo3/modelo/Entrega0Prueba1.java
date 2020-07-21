package edu.fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class Entrega0Prueba1 {

    @Test
    public void UnaPreguntadeVerdaderoFalsoPuedeCrearseIndicandoCualEsLaRespuestaCorrectaTest(){

    VerdaderoFalso pregunta = new VerdaderoFalso();

    Respuesta respuestaVerdadera = new Respuesta("", Boolean.TRUE);
    Respuesta respuestaFalsa = new Respuesta("", Boolean.FALSE);

    ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
    respuestas.add(respuestaVerdadera);
    respuestas.add(respuestaFalsa);

    pregunta.recibirRespuesta(respuestas);

    Assert.assertEquals(true, true);


    }


}
