package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.annotation.JsonCreator;
import edu.fiuba.algo3.modelo.Opcion;
public class OpcionGroup extends Opcion {

    protected String grupo;

    public OpcionGroup(){

    }

    public OpcionGroup(String unaOpcion, String grupo, boolean correcta) {

       // super(unaOpcion, correcta);
        this.texto = unaOpcion;

        this.esCorrecta = correcta;

        this.grupo = grupo;

    }

    public String getGrupo(){

        return grupo;

    }

    public void asignarGrupo(String grupo){

        this.grupo = grupo;

    }

}
