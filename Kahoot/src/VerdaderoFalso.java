


public class VerdaderoFalso {

    private String contenido;
    private Boolean penalidad;

    //Falta que sea una lista de respuestas
    public int recibirRespuesta(Respuesta respuesta){

    int puntos = 0;

    if (respuesta.getEsCorrecta()){
        puntos += 1;
    }

    return puntos;
    }



}
