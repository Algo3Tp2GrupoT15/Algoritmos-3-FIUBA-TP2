package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Preguntas;
import edu.fiuba.algo3.modelo.preguntas.TipoClasico;
import edu.fiuba.algo3.modelo.preguntas.TipoPuntaje;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoYFalso;

import java.util.ArrayList;

public class KahootModel {

    ArrayList<Jugador> jugadores;
    ArrayList<Preguntas> preguntas;
    ArrayList<Respuesta> respuestasDelTurno;

    Exclusividad exclusividad;

    private int numeroDePregunta;
    private int numeroDeJugador;

    public KahootModel(){

        jugadores = new ArrayList<Jugador>();
        preguntas = new ArrayList<Preguntas>();
        respuestasDelTurno = new ArrayList<Respuesta>();

        exclusividad = new Exclusividad();

        int numeroDePregunta = 0;
        int numeroDeJugador = 0;


        leerPreguntas();

    }

    public void leerPreguntas(){ //leeria preguntas de un archivo pero de momento cargo a mano una pregunta para probar

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        TipoPuntaje tipoClasico = new TipoClasico();

        Preguntas verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opciones, tipoClasico);

        preguntas.add(verdaderoYFalso);



    }

    public void cargarJugador(String nombre){

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
    public void proximaPreguntaDeTurno(){
        numeroDePregunta +=1;
        numeroDeJugador = 0;
        respuestasDelTurno = new ArrayList<Respuesta>();

    }

    public void cargarRespuestas(Respuesta respuestaDeJugador){

        respuestasDelTurno.add(respuestaDeJugador);

    }

    public void calcularPuntosDelTurno() {

        for (Respuesta respuesta : respuestasDelTurno) {
            preguntas.get(numeroDePregunta).asignarPuntaje(respuesta);
        }

        exclusividad.modificarPuntos(jugadores);
    }

    public void activarExclusividad(int usos){
        exclusividad.activar(usos);
    }

    public void activarMultiplicador(int factor){

        jugadorDeTurno().asignarMultiplicador(factor);

    }


}
