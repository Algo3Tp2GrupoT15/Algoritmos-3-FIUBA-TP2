package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Preguntas;
import edu.fiuba.algo3.modelo.preguntas.TipoClásico;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;

import java.util.ArrayList;

public class KahootModel {

    ArrayList<Jugador> jugadores;
    ArrayList<Preguntas> preguntas;

    int numeroDePregunta;
    int numeroDeJugador;

    public KahootModel(){

        int numeroDePregunta = 0;
        int numeroDeJugador = 0;

        leerPreguntas();


        cargarJugador("lean");
        cargarJugador("juan");

    }

    public void leerPreguntas(){ //leeria preguntas de un archivo pero de momento cargo a mano una pregunta para probar

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        TipoClásico tipoClásico = new TipoClásico();

        VerdaderoYFalso verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opciones, tipoClásico);

        preguntas.add(verdaderoYFalso);


    }

    public void cargarJugador( String nombre){

        jugadores.add(new Jugador(nombre));

    }


    public String mostrarPreguntaDeTurno(){

        return preguntas.get(numeroDePregunta).contenido();

    }

    public ArrayList<Opcion> mostrarOpcionesDeTurno(){

        return preguntas.get(numeroDePregunta).opciones();
    }

    public Jugador jugadorDeTurno(){

        return jugadores.get(numeroDeJugador);

    }

    public void siguienteJugador(){
        numeroDeJugador +=1;

    }



}
