package oop2.tp3.ejercicio1;

public class LibroNuevo extends Libro{
    public LibroNuevo(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularMonto(int diasAlquilados) {
        return diasAlquilados * 3;
    }

    public int calcularPuntos(int diasAlquilados){
        int puntos = 1;
        if(diasAlquilados > 1){
            puntos++;
        }
        return puntos;
    }
}
