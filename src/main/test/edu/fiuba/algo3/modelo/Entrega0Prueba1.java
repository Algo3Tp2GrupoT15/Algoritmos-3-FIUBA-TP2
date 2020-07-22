package edu.fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class Entrega0Prueba1 {

    @Test
    public void UnaPreguntadeVerdaderoFalsoPuedeCrearseIndicandoCualEsLaRespuestaCorrectaTest(){

    VerdaderoFalso pregunta = new VerdaderoFalso("En Algo3 se ve POO.");

    Respuesta respuestaVerdadera = new Respuesta("", Boolean.TRUE);

    pregunta.setRespuestaCorrecta(respuestaVerdadera);

    Assert.assertEquals(pregunta.esVerdadera(), true);


    }


}
