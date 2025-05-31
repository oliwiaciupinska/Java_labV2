package Zadanie1;

import java.util.Scanner;

public class Zadanie1 {
    public void zad1() {
        Scanner sc = new Scanner(System.in);
        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();

        wypozyczalnia.dodajPojazd("rower", 10);
        wypozyczalnia.dodajPojazd("samochód", 50);
        wypozyczalnia.dodajPojazd("hulajnoga", 15);

        boolean kontynuuj = true;
        while (kontynuuj) {
            System.out.println("\n--- WYPOŻYCZALNIA ---");
            wypozyczalnia.pokazDostepne();
            System.out.print("Wpisz typ pojazdu do wypożyczenia lub 'zakoncz': ");
            String typ = sc.nextLine();

            if (typ.equalsIgnoreCase("zakoncz")) {
                kontynuuj = false;
                continue;
            }

            Pojazd p = wypozyczalnia.wypozycz(typ);
            if (p == null) {
                System.out.println("Brak dostępnych pojazdów tego typu.");
                continue;
            }

            System.out.print("Na ile godzin chcesz wypożyczyć? ");
            int godziny = sc.nextInt();
            sc.nextLine(); // czyszczenie bufora

            double koszt = wypozyczalnia.obliczKoszt(p, godziny);
            System.out.println("Koszt wypożyczenia: " + koszt + " zł");

            wypozyczalnia.zwroc(p);
        }
    }
}
