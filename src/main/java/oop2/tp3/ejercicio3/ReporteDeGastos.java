package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {
    public String generarReporte(List<Gasto> gastos) {
        var repote = new StringBuilder();
        repote.append("Expenses ").append(LocalDate.now()).append("\n");

        int total = gastos.stream().mapToInt(Gasto::monto).sum();
        int gastosDeComida = gastos.stream().mapToInt(Gasto::gastoComidas).sum();
        gastos.stream().map(r -> r.tipoDeGasto() + "\t" + r.monto()+"\t" +
                r.excesoComidas()+"\n").forEach(texto -> repote.append(texto).append("\n"));

        repote.append("Gastos de comida: ").append(gastosDeComida).append("\n");
        repote.append("Total de gastos: ").append(total);
        return repote.toString();
    }

}
    /* vercion solo factorisada con polimorfismo
public class ReporteDeGastos {
    public String generarReporte(List<Gasto> gastos) {
        int total = 0;
        int gastosDeComida = 0;
        var repote = new StringBuilder();
        repote.append("Expenses ").append(LocalDate.now()).append("\n");
        for (Gasto gasto : gastos) {
            gastosDeComida += gasto.gastoComidas();
            repote.append(gasto.tipoDeGasto()).append("\t").append(gasto.monto()).append("\t").append(gasto.excesoComidas()).append("\n");
            total += gasto.monto();
        }
        repote.append("Gastos de comida: ").append(gastosDeComida).append("\n");
        repote.append("Total de gastos: ").append(total);
        return repote.toString();
        }
    }
     */

/* vercion original solo que esta modificado para probarlo con el test
enum TipoDeGasto {
    CENA, DESAYUNO, ALQUILER_AUTO
}

class Gasto {
    TipoDeGasto tipoGasto;
    int monto;
}

public class ReporteDeGastos {
    public String generarReporte(List<Gasto> gastos) {
        int total = 0;
        int gastosDeComida = 0;

        var repote = new StringBuilder();
        repote.append("Expenses ").append(LocalDate.now()).append("\n");

        for (Gasto gasto : gastos) {
            if (gasto.tipoGasto == TipoDeGasto.CENA || gasto.tipoGasto == TipoDeGasto.DESAYUNO) {
                gastosDeComida += gasto.monto;
            }

            String nombreGasto = "";
            switch (gasto.tipoGasto) {
                case CENA:
                    nombreGasto = "Cena";
                    break;
                case DESAYUNO:
                    nombreGasto = "Desayuno";
                    break;
                case ALQUILER_AUTO:
                    nombreGasto = "Alquiler de Autos";
                    break;
            }

            String marcaExcesoComidas = gasto.tipoGasto == TipoDeGasto.CENA && gasto.monto > 5000
                    || gasto.tipoGasto == TipoDeGasto.DESAYUNO && gasto.monto > 1000 ? "X" : " ";

            repote.append(nombreGasto).append("\t").append(gasto.monto).append("\t").append(marcaExcesoComidas).append("\n");

            total += gasto.monto;
        }

        repote.append("Gastos de comida: ").append(gastosDeComida).append("\n");
        repote.append("Total de gastos: ").append(total);
        return repote.toString();
    }
}

 */

/* original
public class ReporteDeGastos {
    public void imprimir(List<Gasto> gastos) {
        int total = 0;
        int gastosDeComida = 0;

        System.out.println("Expenses " + LocalDate.now());

        for (Gasto gasto : gastos) {
            if (gasto.tipoGasto == TipoDeGasto.CENA || gasto.tipoGasto == TipoDeGasto.DESAYUNO) {
                gastosDeComida += gasto.monto;
            }

            String nombreGasto = "";
            switch (gasto.tipoGasto) {
                case CENA:
                    nombreGasto = "Cena";
                    break;
                case DESAYUNO:
                    nombreGasto = "Desayuno";
                    break;
                case ALQUILER_AUTO:
                    nombreGasto = "Alquiler de Autos";
                    break;
            }

            String marcaExcesoComidas = gasto.tipoGasto == TipoDeGasto.CENA && gasto.monto > 5000
                    || gasto.tipoGasto == TipoDeGasto.DESAYUNO && gasto.monto > 1000 ? "X" : " ";

            System.out.println(nombreGasto + "\t" + gasto.monto + "\t" + marcaExcesoComidas);

            total += gasto.monto;
        }

        System.out.println("Gastos de comida: " + gastosDeComida);
        System.out.println("Total de gastos: " + total);
    }
}

 */
