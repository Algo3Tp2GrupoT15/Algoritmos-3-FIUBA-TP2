package edu.fiuba.algo3.modelo;

public class Jugador {

    private int puntaje;
    private String nombre;
    private Multiplicador multiplicador;
    private int ultimoPuntajeAgregado;
    private int usosExclusividad;

    public Jugador() {
        puntaje = 0;
        multiplicador = new Multiplicador();
        nombre = "SinNombre";
        usosExclusividad = 2;
    }

    public Jugador(String nombre) {

        this.nombre = nombre;
        puntaje = 0;
        multiplicador = new Multiplicador();
        usosExclusividad = 2;
    }

    public void agregarPuntaje(int unPuntaje) {

        puntaje += (multiplicador.modificarPuntos(unPuntaje));
        ultimoPuntajeAgregado = unPuntaje;


    }

    public void agregarNombre(String nombre){

        this.nombre = nombre;
    }
    public String  nombre(){

        return this.nombre;
    }

    public int puntaje() {

        return puntaje;

    }


    public void multiplicadorX3(){
        multiplicador.multiplicadorX3();
    }
    public void multiplicadorX2(){

        multiplicador.multiplicadorX2();

    }

    public int getUltimoPuntajeAgregado(){
        return ultimoPuntajeAgregado;
    }

    public int getUsosExclusividad(){
        return usosExclusividad;
    }
    public void disminuirUsosExclusividad(){
        usosExclusividad -= 1;
    }

    public boolean tieneMultiplicadorX2() {
        return multiplicador.getUsosX2()>0;
    }

    public boolean tieneMultiplicadorX3() {
        return multiplicador.getUsosX3()>0;
    }
}
