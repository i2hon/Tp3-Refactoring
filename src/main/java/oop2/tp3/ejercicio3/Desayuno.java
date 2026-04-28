package oop2.tp3.ejercicio3;

public class Desayuno extends Gasto{

    public Desayuno(int monto){
        super(monto);
    }

    public int gastoComidas(){
        return monto();
    }

    @Override
    public String tipoDeGasto() {
        return "Desayuno";
    }

    @Override
    public String excesoComidas(){
        return this.monto > 1000 ? "X" : " ";
    }

}
