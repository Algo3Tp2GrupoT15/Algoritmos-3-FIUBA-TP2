package edu.fiuba.algo3.modelo;

public class Ronda {
    private int numeroDePregunta;

    public Ronda() {
        numeroDePregunta = 1;
    }

    public int numeroRonda() {
        return numeroDePregunta;
    }

    public void siguiente() {
        numeroDePregunta +=1;
    }
}
