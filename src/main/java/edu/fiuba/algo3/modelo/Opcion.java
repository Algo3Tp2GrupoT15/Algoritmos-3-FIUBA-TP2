package edu.fiuba.algo3.modelo;

public class Opcion {
    private final String opcion;
    private final boolean esCorrecta;

    public Opcion(String unaOpcion, boolean correcta) {
        opcion = unaOpcion;
        esCorrecta = correcta;
    }

    public boolean esCorrecta() {
        return esCorrecta;
    }
}
