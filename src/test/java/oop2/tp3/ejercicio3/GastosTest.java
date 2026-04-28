package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GastosTest {
    @Test
    public void testDeGasto(){
        Gasto gasto = new Cena(3);
        /*
        gasto.tipoGasto = TipoDeGasto.CENA;
        gasto.monto = 3;
         */
        assertEquals("Cena", gasto.tipoDeGasto());
        assertEquals(3, gasto.monto);
    }

    @Test
    public void testDeReporte(){
        var g1 = new Desayuno(1001);
        /*
        g1.tipoGasto = TipoDeGasto.DESAYUNO;
        g1.monto =1001;

         */

        var g2 = new AlquilerAuto(3000);
        /*
        g2.tipoGasto = TipoDeGasto.ALQUILER_AUTO;
        g2.monto = 3000;

         */

        var reporte = new ReporteDeGastos();
        String texto = reporte.generarReporte(List.of(g1, g2));

        assertTrue(texto.contains("Expenses " + LocalDate.now()));

        //compueba que se subio el reporte del desayuno
        assertTrue(texto.contains("Desayuno\t1001\tX"));
        /* otra opcion para testear
        assertTrue(texto.contains("Desayuno"));
        assertTrue(texto.contains("1001"));
        assertTrue(texto.contains("X"));
        */

        //compueba que se subio el reporte del auto
        assertTrue(texto.contains("Alquiler de Autos\t3000\t "));

        assertTrue(texto.contains("Gastos de comida: " + 1001));
        assertTrue(texto.contains("Total de gastos: " + 4001));
    }
}
