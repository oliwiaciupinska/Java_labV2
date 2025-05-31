package SystemZarzadzaniaKontami;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager implements AccountOperations {
    private ArrayList<Account> accounts = new ArrayList<>();
    private int nextId = 1;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void createAccount() {
        System.out.println("Wybierz typ konta: 1. Zwykły 2. Moderator 3. Admin");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nazwa użytkownika: ");
        String username = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Hasło: ");
        String password = scanner.nextLine();

        switch (type) {
            case 1 -> {
                System.out.print("Liczba postów: ");
                int postsCount = scanner.nextInt();
                accounts.add(new RegularUser(nextId++, username, email, password, postsCount));
            }
            case 2 -> {
                System.out.print("Liczba zgłoszeń obsłużonych: ");
                int reportsHandled = scanner.nextInt();
                accounts.add(new Moderator(nextId++, username, email, password, reportsHandled));
            }
            case 3 -> {
                System.out.print("Poziom administratora (1-3): ");
                int level = scanner.nextInt();
                accounts.add(new Admin(nextId++, username, email, password, level));
            }
            default -> System.out.println("Nieprawidłowy typ konta.");
        }
    }

    @Override
    public void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("Brak kont do wyświetlenia.");
        } else {
            for (Account acc : accounts) {
                acc.showProfile();
            }
        }
    }

    @Override
    public void updateAccount(int id) {
        Account acc = findAccountById(id);
        if (acc == null) {
            System.out.println("Nie znaleziono konta o ID: " + id);
            return;
        }

        System.out.println("Aktualizacja konta: " + acc.getUsername());
        System.out.print("Nowy email: ");
        String email = scanner.nextLine();
        System.out.print("Nowe hasło: ");
        String password = scanner.nextLine();

        acc.setEmail(email);
        acc.setPassword(password);
        System.out.println("Zaktualizowano dane konta.");
    }

    @Override
    public void deleteAccount(int id) {
        Account acc = findAccountById(id);
        if (acc != null) {
            accounts.remove(acc);
            System.out.println("Usunięto konto o ID: " + id);
        } else {
            System.out.println("Nie znaleziono konta o ID: " + id);
        }
    }

    private Account findAccountById(int id) {
        for (Account acc : accounts) {
            if (acc.getId() == id) return acc;
        }
        return null;
    }
}
