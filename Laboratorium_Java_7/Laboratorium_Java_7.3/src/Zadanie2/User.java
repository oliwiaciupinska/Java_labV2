package Zadanie2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private Map<String, String> users = new HashMap<>();

    public void addUser(Scanner scanner) {
        System.out.print("Wprowadź Login: ");
        String login = scanner.nextLine();
        System.out.print("Wprowadź Hasło: ");
        String password = scanner.nextLine();
        users.put(login, password);
        System.out.println("Użytkownik Dodany.");
    }

    public boolean userExists(String login) {
        return users.containsKey(login);
    }

    public boolean checkPassword(String login, String password) {
        return users.get(login).equals(password);
    }
}
