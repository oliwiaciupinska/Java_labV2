package atm;

import java.util.Scanner;

public class ATMService {
    private UserDAO userDAO = new UserDAO();
    private Scanner scanner = new Scanner(System.in);

    public void loginMenu() {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("PIN: ");
        String pin = scanner.nextLine();

        try {
            User user = userDAO.getUser(login, pin);
            if (user == null) {
                System.out.println("Nieprawidłowy login lub PIN.");
                return;
            }
            if (user.getRole().equals("ADMIN")) {
                adminMenu();
            } else {
                userMenu(user);
            }
        } catch (Exception e) {
            System.out.println("Błąd logowania: " + e.getMessage());
        }
    }

    private void adminMenu() throws Exception {
        System.out.print("Nowy login: ");
        String newLogin = scanner.nextLine();
        System.out.print("Nowy PIN: ");
        String newPin = scanner.nextLine();
        userDAO.createUser(newLogin, newPin, "USER");
        System.out.println("Użytkownik utworzony.");
    }

    private void userMenu(User user) throws Exception {
        while (true) {
            System.out.println("\n1. Wpłata\n2. Wypłata\n3. Zmiana PIN\n4. Sprawdź saldo\n5. Wyloguj");
            System.out.print("Wybierz opcję: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Kwota wpłaty: ");
                    double deposit = Double.parseDouble(scanner.nextLine());
                    userDAO.updateBalance(user.getId(), user.getBalance() + deposit);
                    user.setBalance(user.getBalance() + deposit);
                    break;
                case "2":
                    System.out.print("Kwota wypłaty: ");
                    double withdraw = Double.parseDouble(scanner.nextLine());
                    if (user.getBalance() >= withdraw) {
                        userDAO.updateBalance(user.getId(), user.getBalance() - withdraw);
                        user.setBalance(user.getBalance() - withdraw);
                    } else {
                        System.out.println("Niewystarczające środki.");
                    }
                    break;
                case "3":
                    System.out.print("Nowy PIN: ");
                    String newPin = scanner.nextLine();
                    userDAO.changePin(user.getId(), newPin);
                    System.out.println("PIN zmieniony.");
                    break;
                case "4":
                    System.out.println("Saldo: " + user.getBalance());
                    break;
                case "5":
                    System.out.println("Wylogowano.");
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja.");
            }
        }
    }
}
