package SystemZarzadzaniaKontami;

public interface AccountOperations {
    void createAccount();
    void viewAccounts();
    void updateAccount(int id);
    void deleteAccount(int id);
}