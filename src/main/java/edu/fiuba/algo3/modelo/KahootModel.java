package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.ArrayList;

public class KahootModel {

    ArrayList<Preguntas> preguntas;
    ArrayList<Respuesta> respuestasDelTurno;

    Exclusividad exclusividad;

    private int numeroDePregunta;
    private final Turno turno;

    public KahootModel(){

        turno = new Turno();
        preguntas = new ArrayList<Preguntas>();
        respuestasDelTurno = new ArrayList<Respuesta>();

        exclusividad = new Exclusividad();

        this.numeroDePregunta = 1;


        leerPreguntas();

    }

    public void leerPreguntas(){ //leeria preguntas de un archivo pero de momento cargo a mano una pregunta para probar

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);

        ArrayList<Opcion> opcionesVF = new ArrayList<Opcion>();
        opcionesVF.add(opcionCorrecta);
        opcionesVF.add(opcionIncorrecta);

        TipoPuntaje tipoClasico = new TipoClasico();

        Preguntas verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opcionesVF, tipoClasico);

        preguntas.add(verdaderoYFalso);


        Opcion opcionCorrecta1 = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta1 = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta1);
        opciones.add(opcionCorrecta2);
        opciones.add(opcionIncorrecta1);
        opciones.add(opcionIncorrecta2);
        TipoClasico tipoClásico = new TipoClasico();

        MultipleChoice multipleChoice = new MultipleChoice(" 2+2=..? ", opciones, tipoClásico);

        preguntas.add(multipleChoice);


    }

    public void cargarJugador(String nombre){

        turno.agregarJugador(nombre);

    }


    public String mostrarPreguntaDeTurno(){

        return preguntas.get(numeroDePregunta).contenido();

    }

    public Preguntas preguntaDeTurno(){

        return preguntas.get(numeroDePregunta);

    }

    public ArrayList<Opcion> mostrarOpcionesDeTurno(){

        return preguntas.get(numeroDePregunta).opciones();
    }

    public Jugador jugadorDeTurno(){

        return turno.jugador();

    }

    public void siguienteJugador(){
        turno.siguiente();

    }
    public void proximaPreguntaDeTurno(){
        numeroDePregunta +=1;
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
            preguntas.get(numeroDePregunta).asignarPuntaje(respuesta);
        }

        exclusividad.modificarPuntos(turno.jugadores());
    }

    public void activarExclusividad(int usos){
        exclusividad.activar(usos);
    }

    public void activarMultiplicador(int factor){

        jugadorDeTurno().asignarMultiplicador(factor);

    }


}
