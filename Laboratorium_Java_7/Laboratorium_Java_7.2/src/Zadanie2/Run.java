package Zadanie2;

import java.util.*;

public class Run {

    public Run(){
        Scanner sc = new Scanner(System.in);

        List<String> Pary = new ArrayList<>();
        Pary.add("Bartek i Zuzia");
        Pary.add("Michał i Oskar");
        Pary.add("Tomek i Wiktoria");
        Pary.add("Benedykt  i  Ola");

        String pary;
        String osoba;

        while(true){
            System.out.println("\nAktualna Lista Par");
            for(String par : Pary){
                System.out.println(par);
            }
            System.out.println("\nPodaj następna pare albo znka '-' aby zakończyć dziąłanie programu");
            pary = sc.nextLine();

            if(pary.equals("-")) {
                break;
            }

            Pary.add(pary);

        }

        System.out.println("\nDobrze a teraz podaj imie jednego człowieka z listy");
        osoba = sc.nextLine();
        boolean znaleziona = false;

        for (String par : Pary) {
            String[]osoby = par.split( "i ");
            if(osoby.length == 2) {
                if(osoby[0].equalsIgnoreCase(osoba)) {
                    System.out.println("Imie drugiego  Partnera to : " + osoby[0]);
                    znaleziona = true;
                    break;
                }else if(osoby[1].equalsIgnoreCase(osoba)) {
                    System.out.println("Imie drugiego  Partnera to : " + osoby[0]);
                    znaleziona = true;
                    break;
                }
            }
        }

        if(!znaleziona){
            System.out.println("Nie ma takiej pary");
        }
        sc.close();
    }
}