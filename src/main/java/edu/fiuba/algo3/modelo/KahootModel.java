package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Jason.CreadorDePreguntas;
import edu.fiuba.algo3.Jason.LectorDePreguntas;
import edu.fiuba.algo3.modelo.excepciones.NoHayPreguntasCargadasExcepcion;
import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.ArrayList;

public class KahootModel {

    private final Ronda ronda;
    private ArrayList<Preguntas> preguntas;
    private ArrayList<Respuesta> respuestasDelTurno;

    private Exclusividad exclusividad;
    private Boolean ultimoTurno;

    private Turno turno;

    public KahootModel(){

        turno = new Turno();
        preguntas = new ArrayList<Preguntas>();
        respuestasDelTurno = new ArrayList<Respuesta>();
        ronda = new Ronda();

        exclusividad = new Exclusividad();

        leerPreguntas();

    }

    public void leerPreguntas(){


        LectorDePreguntas lector = new LectorDePreguntas();

        CreadorDePreguntas creadorDePreguntas = new CreadorDePreguntas(lector.getPreguntasLeidas());

        try {
            preguntas = creadorDePreguntas.getPreguntas();
        }catch (NoHayPreguntasCargadasExcepcion noHayPreguntasCargadasExcepcion) {
            noHayPreguntasCargadasExcepcion.printStackTrace();
        }

    }

    public void cargarJugador(String nombre){

        turno.agregarJugador(nombre);

    }


    public String mostrarPreguntaDeTurno(){

        return preguntas.get(ronda.numeroRonda()).contenido();

    }

    public Preguntas preguntaDeTurno(){

        return preguntas.get(ronda.numeroRonda());

    }

    public ArrayList<Opcion> mostrarOpcionesDeTurno(){

        return preguntas.get(ronda.numeroRonda()).opciones();
    }

    public Jugador jugadorDeTurno(){

        return turno.jugador();

    }

    public ArrayList<Jugador> jugadores(){

        return turno.jugadores();

    }

    public void siguienteJugador(){
        turno.siguiente();

    }

    public void proximaPreguntaDeTurno(){
        ronda.siguiente();
        turno.resetearTurno();
        respuestasDelTurno = new ArrayList<Respuesta>();

    }

    public void cargarRespuestas(Respuesta respuestaDeJugador){

        respuestasDelTurno.add(respuestaDeJugador);

    }

    public void cargarPreguntas(Preguntas pregunta){

        preguntas.add(pregunta);

    }

    public void calcularPuntosDelTurno() {

        for (Respuesta respuesta : respuestasDelTurno) {
            preguntas.get(ronda.numeroRonda()).asignarPuntaje(respuesta);
        }

        exclusividad.modificarPuntos(turno.jugadores());
    }

    public void activarExclusividad(int usos){

        exclusividad.activar(usos);

    }



    public boolean ultimoJugador() {

        return turno.esUltimoTurno();

    }


    public boolean esUltimaPregunta(){

        return ((this.ronda.numeroRonda() + 1) == preguntas.size());

    }

}
