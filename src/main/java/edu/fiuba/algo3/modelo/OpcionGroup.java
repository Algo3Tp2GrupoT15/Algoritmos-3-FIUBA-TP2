package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opcion;
public class OpcionGroup extends Opcion {

    private String grupo;

    public OpcionGroup(String unaOpcion, String unGrupo, boolean correcta) {

        super(unaOpcion, correcta);

        grupo = unGrupo;

    }

    public String grupo(){

        return grupo;

    }

    public void asignarGrupo(String unGrupo){

        grupo = unGrupo;

    }

}
