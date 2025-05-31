package SystemZarzadzaniaKontami;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n== MENU ==");
            System.out.println("1. Dodaj konto");
            System.out.println("2. Wyświetl konta");
            System.out.println("3. Edytuj konto");
            System.out.println("4. Usuń konto");
            System.out.println("5. Wyjdź");
            System.out.print("Wybierz opcję: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // czyści bufor

            switch (choice) {
                case 1 -> manager.createAccount();
                case 2 -> manager.viewAccounts();
                case 3 -> {
                    System.out.print("Podaj ID konta do edycji: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    manager.updateAccount(id);
                }
                case 4 -> {
                    System.out.print("Podaj ID konta do usunięcia: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    manager.deleteAccount(id);
                }
                case 5 -> {
                    System.out.println("Zamykam program...");
                    return;
                }
                default -> System.out.println("Nieprawidłowa opcja.");
            }
        }
    }
}
