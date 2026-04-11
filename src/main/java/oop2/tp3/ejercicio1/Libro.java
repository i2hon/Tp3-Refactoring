package oop2.tp3.ejercicio1;

public abstract class Libro {
    public static final int INFANTILES = 2;
    public static final int REGULARES = 0;
    public static final int NUEVO_LANZAMIENTO = 1;
    private String nombre;

    public Libro(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularMonto(int diasAlquilados);

    public int calcularPuntos(int diasAlquilados){
        return 1;
    }

    public String nombre() {
        return nombre;
    }
}