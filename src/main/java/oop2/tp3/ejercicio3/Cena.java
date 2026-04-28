package oop2.tp3.ejercicio3;

public class Cena extends Gasto{

    public Cena(int monto){
        super(monto);
    }

    public int gastoComidas(){
        return monto();
    }

    @Override
    public String tipoDeGasto() {
        return "Cena";
    }

    @Override
    public String excesoComidas(){
        return this.monto > 5000 ? "X" : " ";
    }

}
