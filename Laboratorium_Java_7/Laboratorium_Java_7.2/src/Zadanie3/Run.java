package Zadanie3;

import java.util.Scanner;

public class Run {

    public Run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Użyć LinkedList? (tak/nie): ");
        boolean linked = sc.nextLine().trim().equalsIgnoreCase("tak");

        Wybor wybor = new Wybor(linked);

        while (true) {
            System.out.println("\n1. Dodaj uczestnika");
            System.out.println("2. Pokaż wszystkich");
            System.out.println("3. Pokaż niepełnoletnich");
            System.out.println("0. Wyjdź");
            System.out.print("Wybierz opcję: ");
            String opcja = sc.nextLine();

            switch (opcja) {
                case "1":
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Imię: ");
                    String imie = sc.nextLine();
                    System.out.print("Wiek: ");
                    int wiek = Integer.parseInt(sc.nextLine());

                    wybor.dodaj(new Osoba(id, wiek, imie));
                    break;

                case "2":
                    System.out.println("\nWszyscy uczestnicy:");
                    for (Osoba o : wybor.wszyscy()) {
                        System.out.println(o);
                    }
                    break;

                case "3":
                    System.out.println("\nNiepełnoletni uczestnicy:");
                    for (Osoba o : wybor.niepelnoletni()) {
                        System.out.println(o);
                    }
                    break;

                case "0":
                    System.out.println("Zamykam program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Nie ma takiej opcji.");
            }
        }
    }
}