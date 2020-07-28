package edu.fiuba.algo3.modelo;

public class Opcion {
    private final String texto;
    private final boolean esCorrecta;

    public Opcion(String unaOpcion, boolean correcta) {
        texto = unaOpcion;
        esCorrecta = correcta;
    }

    public boolean esCorrecta() {
        return esCorrecta;
    }


    public String contenido(){
        return texto;
    }

}

