package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class VerdaderoFalso {

    private String contenido;
    private Boolean penalidad;
    private Respuesta respuestaCorrecta;

    public VerdaderoFalso(String contenido){

        this.contenido=contenido;
    }

    public int recibirRespuesta(ArrayList<Respuesta> respuestas){

        return (int) respuestas.stream().filter(Respuesta::getEsCorrecta).count();
    }

    public boolean esVerdadera(){
        return respuestaCorrecta.getEsCorrecta();
    }

    public void setRespuestaCorrecta(Respuesta respuesta){
        this.respuestaCorrecta=respuesta;
    }

}
