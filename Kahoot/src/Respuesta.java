public class Respuesta {

    private Jugador jugadorQueResponde;
    private Boolean esCorrecta;
    private String  contenido;

    public Respuesta(String contenido, Boolean esCorrecta){

        this.esCorrecta = esCorrecta;
        this.contenido = contenido;

    }

    public Boolean getEsCorrecta() {
        return esCorrecta;
    }

    public void remitente(Jugador jugador) {
        this.jugadorQueResponde = jugador;
    }
}

