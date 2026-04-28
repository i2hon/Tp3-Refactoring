package oop2.tp3.ejercicio5;


public abstract class Evento{
    String nombreEvento;
    public Evento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    public abstract float costoEvento(int numberoEspectadores);

    public float creditosGanados(int numberoEspectadores){
        return Math.max(numberoEspectadores - 30, 0);
    }

    public String nombreEvento(){
        return nombreEvento;
    }
}

/*original
public record Evento(String nombreEvento, String tipo) {
}

 */
