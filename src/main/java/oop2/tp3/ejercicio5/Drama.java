package oop2.tp3.ejercicio5;

public class Drama extends Evento{
    public Drama(String nombreEvento) {
        super(nombreEvento);
    }

    @Override
    public float costoEvento(int numberoEspectadores){
        float monto = 40000;
        if (numberoEspectadores > 30) {
            monto += 1000 * (numberoEspectadores - 30);
        }
        return monto;
    }
}
