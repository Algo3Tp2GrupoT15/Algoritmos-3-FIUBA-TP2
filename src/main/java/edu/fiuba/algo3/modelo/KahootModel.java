package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Jason.CreadorArchivoJson;
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

        Opcion opcionCorrecta1 = new Opcion("verdadero",true);
        Opcion opcionIncorrecta1 = new Opcion("falso",false);

        ArrayList<Opcion> opcionesVF1 = new ArrayList<Opcion>();
        opcionesVF1.add(opcionCorrecta1);
        opcionesVF1.add(opcionIncorrecta1);

        TipoPuntaje tipoClasicoVF1 = new TipoClasico();

        Preguntas verdaderoYFalso1 = new VerdaderoYFalso("El cielo es azul", opcionesVF1, tipoClasicoVF1);

        preguntas.add(verdaderoYFalso1);


        Opcion opcionCorrectaMC1 = new Opcion("4",true);
        Opcion opcionCorrectaMC2 = new Opcion("2^2",true);
        Opcion opcionIncorrectaMC1 = new Opcion("8",false);
        Opcion opcionIncorrectaMC2 = new Opcion("Pez",false);

        ArrayList<Opcion> opcionesMC = new ArrayList<Opcion>();
        opcionesMC.add(opcionCorrectaMC1);
        opcionesMC.add(opcionCorrectaMC2);
        opcionesMC.add(opcionIncorrectaMC1);
        opcionesMC.add(opcionIncorrectaMC2);

        TipoClasico tipoClasicoMC = new TipoClasico();

        MultipleChoice multipleChoice = new MultipleChoice(" 2+2=..? ", opcionesMC, tipoClasicoMC);

        preguntas.add(multipleChoice);


        Opcion opcionOC11 = new Opcion("2",true);
        Opcion opcionOC12 = new Opcion("4",true);
        Opcion opcionOC13 = new Opcion("6",true);
        Opcion opcionOC14 = new Opcion("8",true);

        ArrayList<Opcion> opcionesEnOrden1 = new ArrayList<Opcion>(Arrays.asList());
        opcionesEnOrden1.add(opcionOC11);
        opcionesEnOrden1.add(opcionOC12);
        opcionesEnOrden1.add(opcionOC13);
        opcionesEnOrden1.add(opcionOC14);

        OrderedChoice orderedChoice1 = new OrderedChoice(" Ordene los numeros de forma ascendente ", opcionesEnOrden1);

        preguntas.add(orderedChoice1);


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


        Opcion opcionCorrecta2 = new Opcion("falso",true);
        Opcion opcionIncorrecta2 = new Opcion("verdadero",false);

        ArrayList<Opcion> opcionesVF2 = new ArrayList<Opcion>();
        opcionesVF2.add(opcionCorrecta2);
        opcionesVF2.add(opcionIncorrecta2);

        TipoPuntaje tipoClasicoVF2 = new TipoClasico();

        Preguntas verdaderoYFalso2 = new VerdaderoYFalso("Argentina limita con Perú.", opcionesVF2, tipoClasicoVF2);

        preguntas.add(verdaderoYFalso2);


        Opcion opcionOC21 = new Opcion("4",true);
        Opcion opcionOC22 = new Opcion("3",true);
        Opcion opcionOC23 = new Opcion("2",true);
        Opcion opcionOC24 = new Opcion("1",true);

        ArrayList<Opcion> opcionesEnOrden2 = new ArrayList<Opcion>(Arrays.asList());
        opcionesEnOrden2.add(opcionOC21);
        opcionesEnOrden2.add(opcionOC22);
        opcionesEnOrden2.add(opcionOC23);
        opcionesEnOrden2.add(opcionOC24);

        OrderedChoice orderedChoice2 = new OrderedChoice(" Ordene los numeros de forma descendente ", opcionesEnOrden2);

        preguntas.add(orderedChoice2);


        CreadorArchivoJson json = new CreadorArchivoJson(preguntas);

       /*LectorDePreguntas lector = new LectorDePreguntas();

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



    public boolean ultimoJugador() {

        return turno.esUltimoTurno();

    }


    public boolean esUltimaPregunta(){

        return ((this.ronda.numeroRonda() + 1) == preguntas.size());

    }

}
