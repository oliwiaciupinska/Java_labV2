package Zadanie1;

public class Pojazd {
    private String typ;
    private double cenaZaGodzine;
    private boolean wypozyczony;

    public Pojazd(String typ, double cenaZaGodzine) {
        this.typ = typ;
        this.cenaZaGodzine = cenaZaGodzine;
        this.wypozyczony = false;
    }

    public String getTyp() { return typ; }
    public double getCenaZaGodzine() { return cenaZaGodzine; }
    public boolean isWypozyczony() { return wypozyczony; }
    public void setWypozyczony(boolean w) { this.wypozyczony = w; }

    @Override
    public String toString() {
        return typ + " - " + (wypozyczony ? "wypożyczony" : "dostępny") + " - " + cenaZaGodzine + " zł/h";
    }
}
