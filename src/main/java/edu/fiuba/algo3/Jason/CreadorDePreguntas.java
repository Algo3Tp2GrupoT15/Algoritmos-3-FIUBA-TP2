package edu.fiuba.algo3.Jason;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.excepciones.NoHayPreguntasCargadasExcepcion;
import edu.fiuba.algo3.modelo.excepciones.PreguntaNoIdentificadaExcepcion;
import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CreadorDePreguntas {

    private ArrayList<Preguntas> preguntas;



    public CreadorDePreguntas(ArrayList<PreguntaACrearInfo> preguntasLeidas) {

        preguntas = new ArrayList<Preguntas>();

        for (PreguntaACrearInfo preguntasLeida : preguntasLeidas) {
            try {
                determinarPreguntaACrear(preguntasLeida);
            } catch (PreguntaNoIdentificadaExcepcion preguntaNoIdentificadaExcepcion) {
                preguntaNoIdentificadaExcepcion.printStackTrace();
            }
        }


    }

    private void determinarPreguntaACrear(PreguntaACrearInfo preguntaDatos) throws PreguntaNoIdentificadaExcepcion {

        switch (preguntaDatos.getTipoDePregunta()){


            case "VerdaderoFalsoClasico":
                VerdaderoYFalso verdaderoYFalso = new VerdaderoYFalso(preguntaDatos.getContenido(), preguntaDatos.getOpciones(), new TipoClasico());
                preguntas.add(verdaderoYFalso);
                break;

            case "VerdaderoFalsoConPenalidad":
                VerdaderoYFalso verdaderoFalsoConPenalidad = new VerdaderoYFalso(preguntaDatos.getContenido(), preguntaDatos.getOpciones(), new TipoConPenalidad());
                preguntas.add(verdaderoFalsoConPenalidad);
                break;

            case "MultipleChoiceClasico" :
                MultipleChoice multipleChoice = new MultipleChoice(preguntaDatos.getContenido(), preguntaDatos.getOpciones(), new TipoClasico());
                preguntas.add(multipleChoice);
                break;
            case "MultipleChoiceConPenalidad" :
                MultipleChoice multipleChoiceConPenalidad = new MultipleChoice(preguntaDatos.getContenido(), preguntaDatos.getOpciones(), new TipoConPenalidad());
                preguntas.add(multipleChoiceConPenalidad);
                break;
            case "MultipleChoiceConPutajeParcial" :
                MultipleChoice multipleChoiceConPutajeParcial = new MultipleChoice(preguntaDatos.getContenido(), preguntaDatos.getOpciones(), new TipoParcial());
                preguntas.add(multipleChoiceConPutajeParcial);
                break;
            case "OrderedChoice" :
                OrderedChoice orderedChoice = new OrderedChoice(preguntaDatos.getContenido(), preguntaDatos.getOpciones());
                preguntas.add(orderedChoice);
                break;
            case "GroupChoice" :

                ArrayList<Opcion> opciones = new ArrayList<Opcion>((preguntaDatos.getOpcionesGrupo()));
                GroupChoice groupChoice = new GroupChoice(preguntaDatos.getContenido(), opciones,new TipoClasico());
                preguntas.add(groupChoice);
                break;
            default:
                throw new PreguntaNoIdentificadaExcepcion("Tipo de pregunta no identificada");
        }


    }

    public ArrayList<Preguntas> getPreguntas() throws NoHayPreguntasCargadasExcepcion {

        if (preguntas.isEmpty()){
            throw  new NoHayPreguntasCargadasExcepcion("No hay pregfuntas cargadas");
        }

        return preguntas;
    }
}
