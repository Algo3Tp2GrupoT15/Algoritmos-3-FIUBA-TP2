package edu.fiuba.algo3.modelo;

public class Opcion {

    protected String texto;
    protected boolean esCorrecta;


    public Opcion(){

    }

    public Opcion(String unaOpcion, boolean correcta) {

        texto = unaOpcion;
        esCorrecta = correcta;

    }


    public String contenido(){
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


    public boolean esCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }


}

