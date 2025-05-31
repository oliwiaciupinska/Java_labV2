package atm;

public class ATMApp {
    public static void main(String[] args) {
        ATMService atmService = new ATMService();
        while (true) {
            atmService.loginMenu();
        }
    }
}
