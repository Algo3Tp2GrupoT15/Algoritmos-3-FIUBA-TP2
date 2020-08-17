package edu.fiuba.algo3.Jason;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LectorDePreguntas {




    private ArrayList<PreguntaACrearInfo> preguntasLeidas;

    public LectorDePreguntas(){

        preguntasLeidas = new ArrayList<PreguntaACrearInfo>();

        leerPreguntas();

    }

    private void leerPreguntas() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            String preguntasPath = "src/main/java/recursos/Preguntas.json";
            //PreguntaACrearInfo preguntaLeida = mapper.readValue(new File(preguntasPath), PreguntaACrearInfo.class);
            //preguntasLeidas.add(preguntaLeida);

            PreguntaACrearInfo[] preguntasJSon = mapper.readValue(new File(preguntasPath), PreguntaACrearInfo[].class);

            preguntasLeidas.addAll(Arrays.asList(preguntasJSon));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<PreguntaACrearInfo> getPreguntasLeidas() {
        return preguntasLeidas;
    }

}
