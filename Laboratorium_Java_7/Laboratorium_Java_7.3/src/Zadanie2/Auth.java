package Zadanie2;

import java.util.Scanner;

public class Auth {
    private User userManager;

    public Auth(User userManager) {
        this.userManager = userManager;
    }

    public void login(Scanner scanner) {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Hasło: ");
        String password = scanner.nextLine();

        if (userManager.userExists(login) && userManager.checkPassword(login, password)) {
            System.out.println("Udało się zalogować!");
        } else {
            System.out.println("Błędny Logi albo Haasło.");
        }
    }
}
