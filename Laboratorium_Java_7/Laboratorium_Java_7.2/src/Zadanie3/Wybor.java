package Zadanie3;

import java.util.*;

public class Wybor {
    private List<Osoba> uczestnicy;

    public Wybor(boolean linkedList) {
        if (linkedList) {
            uczestnicy = new LinkedList<>();
        } else {
            uczestnicy = new ArrayList<>();
        }

        // Przykładowi uczestnicy
        uczestnicy.add(new Osoba(1, 17, "Wiktoria"));
        uczestnicy.add(new Osoba(2, 23, "Jakub"));
        uczestnicy.add(new Osoba(3, 21, "Oliwia"));
    }

    public void dodaj(Osoba osoba) {
        uczestnicy.add(osoba);
    }

    public List<Osoba> wszyscy() {
        return uczestnicy;
    }

    public List<Osoba> niepelnoletni() {
        List<Osoba> wynik = new ArrayList<>();
        for (Osoba o : uczestnicy) {
            if (o.getWiek() < 18) {
                wynik.add(o);
            }
        }
        return wynik;
    }
}