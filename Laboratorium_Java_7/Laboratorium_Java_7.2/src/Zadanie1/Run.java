package Zadanie1;

import java.util.*;

public class Run {

    public Run() {
        Scanner sc = new Scanner(System.in);

        List<String> imie = new ArrayList<>();
        imie.add("Wiktoria");
        imie.add("Ola");
        imie.add("Oliwia");
        imie.add("Ania");

        String imiona;

        while(true) {
            System.out.println("\nLista Par");
            for(String im : imie) {
                System.out.println(im);
            }
            System.out.println("\nPodaj nastepne imie albo znak '-' żeby sprawdzić ile jest unikalnych imion i zakonczyc działanie programu " );
            imiona = sc.nextLine();

            if(imiona.equals("-")) {
                break;
            }

            imie.add(imiona);
        }

        Set<String> Unikalne = new HashSet<>(imie);
        System.out.println("\nAktualnych imion jest: " + Unikalne.size());

    }
}