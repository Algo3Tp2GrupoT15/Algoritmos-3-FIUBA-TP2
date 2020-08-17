package edu.fiuba.algo3.Jason;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class PreguntaACrearInfo {


    private String tipoDePregunta;
    private String contenido;
    private ArrayList<Opcion> opciones;


    public PreguntaACrearInfo(){}

    public String getTipoDePregunta() {
        return tipoDePregunta;
    }

    public void setTipoDePregunta(String tipoDePregunta) {
        this.tipoDePregunta = tipoDePregunta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ArrayList<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        this.opciones = opciones;
    }
}
