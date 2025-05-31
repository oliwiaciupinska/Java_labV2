package Zadanie2;

import java.util.Scanner;

public class Run {
    private User userManager = new User();
    private Auth authService = new Auth(userManager);
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n Menu");
            System.out.println("1. Dodaj użytkownika");
            System.out.println("2. Zaloguj sie ");
            System.out.println("3. Wyjdź");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> userManager.addUser(scanner);
                case 2 -> authService.login(scanner);
                case 3 -> {
                    System.out.println("Wyjście.");
                    return;
                }
                default -> System.out.println("Nie ma takiej opcji.");
            }
        }
    }
}