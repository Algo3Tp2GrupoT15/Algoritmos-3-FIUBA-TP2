package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;
import java.util.Collections;


public class OrderedChoice implements Preguntas {

    private final String texto;
    private ArrayList<Opcion> opciones;
    private String tipoDePregunta;
    private TipoPuntaje tipo;

    public OrderedChoice(String enunciado,ArrayList<Opcion> opciones) {

        this.texto = enunciado;
        this.opciones = opciones;
        tipoDePregunta = "OrderedChoice";
        tipo = new TipoClasico();

    }


    @Override
    public ArrayList<Opcion> opciones() {

        ArrayList<Opcion> opcinesOrdenAleatorio = opciones;
        Collections.shuffle(opcinesOrdenAleatorio);

        return (opcinesOrdenAleatorio);
    }

    @Override
    public void asignarPuntaje(Respuesta respuesta) {

        if(this.opciones.equals(respuesta.opciones())){

            respuesta.asignarPuntajeAlJugador(1);
        }

    }

    @Override
    public String contenido() {
        return texto;
    }

    @Override
    public ArrayList<Opcion> opcionesCorrectas() {
        return opciones;
    }

    @Override
    public String tipoDePregunta() {
        return tipoDePregunta;
    }

    @Override
    public TipoPuntaje tipo() {
        return tipo;
    }


}
