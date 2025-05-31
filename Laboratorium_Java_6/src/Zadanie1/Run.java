package Zadanie1;

import java.util.Scanner;

public class Run {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        Zadanie1 zadanie1 = new Zadanie1();

        boolean wyjscie = true;
        while (wyjscie) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Zadanie 1 - Wypożyczalnia");
            System.out.println("2. Wyjście");

            int wybor = scanner.nextInt();
            scanner.nextLine(); // czyszczenie bufora

            switch (wybor) {
                case 1 -> zadanie1.zad1();
                case 2 -> {
                    wyjscie = false;
                    System.out.println("Zamykanie programu...");
                }
                default -> System.out.println("Nieprawidłowa opcja.");
            }
        }

        scanner.close();
    }
}
