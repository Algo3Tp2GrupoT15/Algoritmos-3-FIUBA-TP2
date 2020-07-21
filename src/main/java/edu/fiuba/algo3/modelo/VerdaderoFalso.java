package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class VerdaderoFalso {

    private String contenido;
    private Boolean penalidad;

    public int recibirRespuesta(ArrayList<Respuesta> respuestas){

        return (int) respuestas.stream().filter(Respuesta::getEsCorrecta).count();
    }



}
