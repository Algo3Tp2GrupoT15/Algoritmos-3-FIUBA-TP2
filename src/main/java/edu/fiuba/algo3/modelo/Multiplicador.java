package edu.fiuba.algo3.modelo;

public class Multiplicador {


    int usosX2;

    int usosX3;

    int factor;

    public Multiplicador(){

            factor = 1;

             usosX2 = 1;

              usosX3 = 1;

    }


    public void multiplicadorX2() {
        this.factor *=2;
        usosX2 -= 1;
    }
    public void multiplicadorX3() {
        this.factor *=3;
        usosX3 -= 1 ;
    }


    public int modificarPuntos(int puntos){

        int puntosMultiplicados = puntos * factor;
        factor = 1;
        return puntosMultiplicados;

    }

    public int getUsosX2() {
        return usosX2;
    }

    public int getUsosX3() {
        return usosX3;
    }
}
