


public class VerdaderoFalso {

    private String contenido;
    private Boolean penalidad;


    public int recibirRespuesta(Respuesta respuesta){

    int puntos = 0;

    if (respuesta.getEsCorrecta()){
        puntos += 1;
    }

    return puntos;
    }



}
