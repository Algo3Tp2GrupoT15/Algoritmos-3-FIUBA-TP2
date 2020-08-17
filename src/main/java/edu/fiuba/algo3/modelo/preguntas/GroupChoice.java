package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

public class GroupChoice implements Preguntas{

    private final String texto;
    private ArrayList<Opcion> opciones;
    protected TipoPuntaje tipo;

    public GroupChoice(String enunciado,ArrayList<Opcion> opciones,TipoPuntaje unTipo) {

        this.texto = enunciado;
        this.opciones = opciones;
        this.tipo = unTipo;

    }

    public ArrayList<Opcion> opciones() {

        return opciones;

    }


    public void asignarPuntaje(Respuesta respuesta) {

        tipo.asignarPuntaje(respuesta,this.opcionesCorrectas().size());

    }


    public String contenido() {
        return texto;
    }


    public ArrayList<Opcion> opcionesCorrectas() {

        ArrayList<Opcion> correctas;

        correctas = opciones.stream().filter(opcion -> opcion.esCorrecta()).collect(toCollection(ArrayList::new));

        return correctas;

    }
}
