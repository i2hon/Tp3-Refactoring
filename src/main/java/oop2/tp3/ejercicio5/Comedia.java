package oop2.tp3.ejercicio5;

public class Comedia extends Evento{
    public Comedia(String nombreEvento) {
        super(nombreEvento);
    }

    @Override
    public float costoEvento(int numberoEspectadores){
        float monto = 30000;
        if (numberoEspectadores > 20) {
            monto += 10000 + 500 * (numberoEspectadores - 20);
        }
        monto += 300 * numberoEspectadores;
        return monto;
    }

    @Override
    public float creditosGanados(int numberoEspectadores){
        float creditos = Math.max(numberoEspectadores - 30, 0);
        creditos += Math.floor(numberoEspectadores / 5);
        return creditos;
    }
}
