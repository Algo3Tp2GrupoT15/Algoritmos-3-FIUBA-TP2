package edu.fiuba.algo3.Jason;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionGroup;

import java.util.ArrayList;

public class PreguntaACrearInfo {


    private String tipoDePregunta;
    private String contenido;
    private ArrayList<Opcion> opciones;
    private ArrayList<OpcionGroup> opcionesGrupo;


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

    public ArrayList<OpcionGroup> getOpcionesGrupo() {
        return opcionesGrupo;
    }

    public void setOpcionesGrupo(ArrayList<OpcionGroup> opcionesGrupo) {
        this.opcionesGrupo = opcionesGrupo;
    }
}
