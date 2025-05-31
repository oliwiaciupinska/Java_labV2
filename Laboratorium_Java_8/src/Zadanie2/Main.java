package Zadanie2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanie 2:");

        for (PizzaSize size : PizzaSize.values()) {
            System.out.println(size + ": " + size.getSrednica() + " cm, " + size.getCena() + " zł");
        }
    }
}

enum PizzaSize {
    MALA(25, 18.99),
    SREDNIA(30, 24.99),
    DUZA(40, 32.99);

    private final int srednica;
    private final double cena;

    PizzaSize(int srednica, double cena) {
        this.srednica = srednica;
        this.cena = cena;
    }

    public int getSrednica() {
        return srednica;
    }

    public double getCena() {
        return cena;
    }
}
