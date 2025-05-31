package Zadanie4;

public class Produkty {
    private String nazwa;

    // Konstruktor, który przyjmuje nazwę produktu
    public Produkty(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}