package Zadanie4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Run {

    public Run() {

        Produkty[] tablicaProduktow = {
                new Produkty("Szampon"),
                new Produkty("Krem"),
                new Produkty("Lakier"),
                new Produkty("Pomadka"),
                new Produkty("Szminka"),
                new Produkty("Tusz")
        };

        List<Produkty> lista = new ArrayList<>(Arrays.asList(tablicaProduktow));

        System.out.println("Lista Produktów:");
        for (Produkty p : lista) {
            System.out.println(" " + p);
        }

        // WYCIĘCIE PODLISTY
        List<Produkty> podlista = lista.subList(2, 4); // Piwo, Bułki

        System.out.println("\nPodlista:");
        for (Produkty produkt : podlista) {
            System.out.println(" " + produkt);
        }

        // USUNIĘCIE TEJ PODLISTY
        podlista.clear();

        System.out.println("\nLista po usunięciu Podlisty:");
        for (Produkty produkt : lista) {
            System.out.println(" " + produkt);
        }
    }
}