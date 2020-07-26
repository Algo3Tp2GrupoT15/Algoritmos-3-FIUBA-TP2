package edu.fiuba.algo3.modelo;

public class Opcion {
    private final String contenido;
    private final boolean esCorrecta;

    public Opcion(String unaOpcion, boolean correcta) {
        contenido = unaOpcion;
        esCorrecta = correcta;
    }

    public boolean esCorrecta() {
        return esCorrecta;
    }


    public String contenido(){
        return contenido;
    }

}

