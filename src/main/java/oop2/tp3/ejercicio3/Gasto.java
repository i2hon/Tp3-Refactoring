package oop2.tp3.ejercicio3;

public abstract class Gasto {
    int monto;

    public Gasto(int monto){
        this.monto = monto;
    }
    //si es alquiler de autos retornara 0
    public int gastoComidas(){
        return 0;
    }
    public abstract String tipoDeGasto();

    public String excesoComidas(){
        return " ";
    }
    public int monto(){
        return monto;
    }
}

