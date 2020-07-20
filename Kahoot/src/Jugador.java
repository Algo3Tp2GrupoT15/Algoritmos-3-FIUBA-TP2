public class Jugador {


    private String nombre;
    private int puntos;


    public Jugador(String nombre){

        this.nombrar(nombre);
    }

    public void nombrar(String nombre){

        this.nombre = nombre;
    }

    public void responde(VerdaderoFalso pregunta, Respuesta respuesta){

        respuesta.remitente(this);

        this.puntos = pregunta.recibirRespuesta(respuesta);

    }

    public int getPuntos() {
        return puntos;
    }
}
