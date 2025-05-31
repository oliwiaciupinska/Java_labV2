package Zadanie1;

import java.util.ArrayList;
import java.util.List;

public class Wypozyczalnia {
    private List<Pojazd> pojazdy = new ArrayList<>();

    public void dodajPojazd(String typ, double cenaZaGodzine) {
        pojazdy.add(new Pojazd(typ, cenaZaGodzine));
    }

    public void pokazDostepne() {
        for (Pojazd p : pojazdy) {
            if (!p.isWypozyczony()) {
                System.out.println("- " + p);
            }
        }
    }

    public Pojazd wypozycz(String typ) {
        for (Pojazd p : pojazdy) {
            if (p.getTyp().equalsIgnoreCase(typ) && !p.isWypozyczony()) {
                p.setWypozyczony(true);
                return p;
            }
        }
        return null;
    }

    public void zwroc(Pojazd p) {
        p.setWypozyczony(false);
    }

    public double obliczKoszt(Pojazd p, int godziny) {
        return p.getCenaZaGodzine() * godziny;
    }
}
