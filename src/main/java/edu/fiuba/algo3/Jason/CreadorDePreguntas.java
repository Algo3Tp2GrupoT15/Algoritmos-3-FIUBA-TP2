package edu.fiuba.algo3.Jason;

import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.ArrayList;

public class CreadorDePreguntas {

    private ArrayList<Preguntas> preguntas;



    public CreadorDePreguntas(ArrayList<PreguntaACrearInfo> preguntasLeidas) {

        preguntas = new ArrayList<Preguntas>();

        preguntasLeidas.forEach(this::determinarPreguntaACrear);


    }

    private void determinarPreguntaACrear(PreguntaACrearInfo preguntaDatos) {

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
                GroupChoice groupChoice = new GroupChoice(preguntaDatos.getContenido(), preguntaDatos.getOpciones(),new TipoClasico());
                preguntas.add(groupChoice);
                break;
        }


    }

    public ArrayList<Preguntas> getPreguntas() {
        return preguntas;
    }
}
