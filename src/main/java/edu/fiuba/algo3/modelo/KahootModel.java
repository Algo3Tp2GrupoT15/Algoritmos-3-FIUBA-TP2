package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Jason.CreadorDePreguntas;
import edu.fiuba.algo3.Jason.LectorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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

    public void leerPreguntas(){ //leeria preguntas de un archivo pero de momento cargo a mano una pregunta para probar

        Opcion opcionCorrecta = new Opcion("verdadero",true);
        Opcion opcionIncorrecta = new Opcion("falso",false);

        ArrayList<Opcion> opcionesVF = new ArrayList<Opcion>();
        opcionesVF.add(opcionCorrecta);
        opcionesVF.add(opcionIncorrecta);

        TipoPuntaje tipoClasicoVF = new TipoClasico();

        Preguntas verdaderoYFalso = new VerdaderoYFalso("El cielo es azul", opcionesVF, tipoClasicoVF);

        preguntas.add(verdaderoYFalso);


        Opcion opcionCorrecta1 = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta1 = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opcionesMC = new ArrayList<Opcion>();
        opcionesMC.add(opcionCorrecta1);
        opcionesMC.add(opcionCorrecta2);
        opcionesMC.add(opcionIncorrecta1);
        opcionesMC.add(opcionIncorrecta2);

        TipoClasico tipoClasicoMC = new TipoClasico();

        MultipleChoice multipleChoice = new MultipleChoice(" 2+2=..? ", opcionesMC, tipoClasicoMC);

        preguntas.add(multipleChoice);


        Opcion opcionOC1 = new Opcion("2",true);
        Opcion opcionOC2 = new Opcion("4",true);
        Opcion opcionOC3 = new Opcion("6",true);
        Opcion opcionOC4 = new Opcion("8",true);

        ArrayList<Opcion> opcionesEnOrden = new ArrayList<Opcion>(Arrays.asList());
        opcionesEnOrden.add(opcionOC1);
        opcionesEnOrden.add(opcionOC2);
        opcionesEnOrden.add(opcionOC3);
        opcionesEnOrden.add(opcionOC4);

        OrderedChoice orderedChoice = new OrderedChoice(" Ordene los numeros de forma ascendente ", opcionesEnOrden);

        preguntas.add(orderedChoice);


        OpcionGroup opcionGC1 = new OpcionGroup("1", "impar", true);
        OpcionGroup opcionGC2 = new OpcionGroup("2", "par", true);
        OpcionGroup opcionGC3 = new OpcionGroup("3", "impar", true);
        OpcionGroup opcionGC4 = new OpcionGroup("4", "par", true);

        ArrayList<Opcion> opcionesEnGrupos = new ArrayList<>(Arrays.asList());
        opcionesEnGrupos.add(opcionGC1);
        opcionesEnGrupos.add(opcionGC2);
        opcionesEnGrupos.add(opcionGC3);
        opcionesEnGrupos.add(opcionGC4);
        TipoClasico tipoClasicoGC = new TipoClasico();

        GroupChoice groupChoice = new GroupChoice(" Clasifique los numeros en pares e impares ", opcionesEnGrupos, tipoClasicoGC);

        preguntas.add(groupChoice);


   /*     LectorDePreguntas lector = new LectorDePreguntas();

        CreadorDePreguntas creadorDePreguntas = new CreadorDePreguntas(lector.getPreguntasLeidas());
        preguntas = creadorDePreguntas.getPreguntas();*/


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

    public void activarMultiplicador(int factor){

        jugadorDeTurno().asignarMultiplicador(factor);

    }


    public boolean ultimoJugador() {
        return turno.esUltimoTurno();
    }
}
