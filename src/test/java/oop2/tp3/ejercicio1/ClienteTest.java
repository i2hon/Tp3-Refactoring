package oop2.tp3.ejercicio1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    @Test
    public void crearLibros(){
        //costructores
        //regular
        Libro regular = new LibroRegular("El codigo Da Vinci");

        //ninos
        Libro ninos = new LibroInfantil("Caperucita Roja");

        //nuevo lanzamiento
        Libro nuevoL = new LibroNuevo("D&D 6E");

        //test
        //test costructor
        assertEquals("El codigo Da Vinci", regular.nombre());
        assertEquals("Caperucita Roja", ninos.nombre());
        assertEquals("D&D 6E", nuevoL.nombre());

        //test comportamiento monto
        assertEquals(2,regular.calcularMonto(2));
        assertEquals(1.5,ninos.calcularMonto(2));
        assertEquals(6,nuevoL.calcularMonto(2));

        //test comportamiento puntos
        assertEquals(1,regular.calcularPuntos(2));
        assertEquals(1,ninos.calcularPuntos(2));
        assertEquals(2,nuevoL.calcularPuntos(2));
    }

    @Test
    public void crearCopiaLibro(){
        //costructor
        CopiaLibro copia = new CopiaLibro(new LibroInfantil("Los 3 Moqueteros"));

        //test
        assertEquals("Los 3 Moqueteros", copia.libro().nombre());
        assertEquals(1, copia.libro().calcularPuntos(4));

        /* test pero recuperando el libro
        Libro original = copia.libro();
        assertEquals("Los 3 Moqueteros", original.nombre());
        */
    }

    @Test
    public void crearAlquiler(){
        //costructor
        //despues agregar un verificar fecha en alquiler porque puedo poner valor negativo
        CopiaLibro copia = new CopiaLibro(new LibroInfantil("Los 3 Moqueteros"));
        Alquiler alquiler = new Alquiler(copia, 2);

        //test
        assertEquals("Los 3 Moqueteros", alquiler.copia().libro().nombre());
        //o podria cambiar 2 por Libro.INFANTILES
        assertEquals(1.5, alquiler.calcularMonto());
        assertEquals(1, alquiler.calcularPuntos());
    }

    @Test
    public void crearCliente(){
        //costructor
        Cliente cliente = new Cliente("carlos");

        //test
        assertEquals("carlos", cliente.nombre());
    }

    @Test
    public void alquilarLibro(){
        //costructor
        Cliente cliente = new Cliente("carlos");
        CopiaLibro copia = new CopiaLibro(new LibroInfantil("Los 3 Moqueteros"));
        Alquiler alquiler = new Alquiler(copia, 2);

        //agregar alquiler
        int tamanoAlquilerActual = cliente.librosAlquilados().size();
        cliente.alquilar(alquiler);

        //test
        assertEquals(tamanoAlquilerActual+1, cliente.librosAlquilados().size());
        assertTrue(cliente.librosAlquilados().contains(alquiler));
    }

    @Test
    public void puntosDeAlquiler(){
        //costructor
        Cliente cliente = new Cliente("carlos");
        CopiaLibro copia = new CopiaLibro(new LibroInfantil("Los 3 Moqueteros"));
        Alquiler alquiler = new Alquiler(copia, 2);

        //agregar alquiler
        cliente.alquilar(alquiler);

        //puntos de alquiler
        Object[] puntos = cliente.calcularDeudaYPuntosObtenidos();
        /*
        total = 0
        puntosAlquilerFrecuente = 0
        infantil: total = 0+1.5
        dias alquilados: dias alquilados es menor que 3 entonces no suma nada al total
        puntosAlquilerFrecuente = 0+1
        no es un nuevo lanzamiento entonces no se le suma el pluss

        resultado:
        total = 1.5
        puntosAlquilerFrecuente = 1
        */

        //test
        assertEquals(1.5,puntos[0]);
        assertEquals(1,puntos[1]);

    }

    @Test
    public void puntosDeAlquilerConCadaTipoDeLibro(){
        //costructor
        Cliente cliente = new Cliente("carlos");

        CopiaLibro copia1 = new CopiaLibro(new LibroInfantil("Los 3 Moqueteros"));
        Alquiler alquiler1 = new Alquiler(copia1, 4);

        CopiaLibro copia2 = new CopiaLibro(new LibroRegular("El codigo Da Vinci"));
        Alquiler alquiler2 = new Alquiler(copia2, 5);

        CopiaLibro copia3 = new CopiaLibro(new LibroNuevo("D&D 6E"));
        Alquiler alquiler3 = new Alquiler(copia3, 6);

        //agregar alquiler
        cliente.alquilar(alquiler1);
        cliente.alquilar(alquiler2);
        cliente.alquilar(alquiler3);

        //puntos de alquiler
        Object[] puntos = cliente.calcularDeudaYPuntosObtenidos();
        /*
        infantil:
        total = 0
        puntosAlquilerFrecuente = 0
        infantil: total = 0+1.5
        dias alquilados: dias alquilados es mayor que 3 entonces se suma un pluss al total
        total = 1.5+(4-3)*1.5 = 3
        puntosAlquilerFrecuente = 0+1
        no es un nuevo lanzamiento entonces no se le suma el pluss

        regular:
        total = 3
        puntosAlquilerFrecuente = 1
        regular: total = 3+2
        dias alquilados: dias alquilados es mayor que 2 entonces se suma un pluss al total
        total = 5+(5-2)*1.5 = 9.5
        puntosAlquilerFrecuente = 1+1
        no es un nuevo lanzamiento entonces no se le suma el pluss

        nuevo lanzamiento:
        total = 9.5
        puntosAlquilerFrecuente = 2
        nuevo lanzamiento: total = 9.5+6*3 = 27.5
        puntosAlquilerFrecuente = 2+1
        es un nuevo lanzamiento y los dias alquilados son mayores a 1 entonces se le suma el pluss a los puntos frecuentes
        puntosAlquilerFrecuente = 3+1 = 4

        resultado:
        total = 27.5
        puntosAlquilerFrecuente = 4
        */

        //test
        assertEquals(27.5,puntos[0]);
        assertEquals(4,puntos[1]);

    }

}
