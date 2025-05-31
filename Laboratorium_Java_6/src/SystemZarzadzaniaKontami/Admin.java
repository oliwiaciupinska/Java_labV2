package SystemZarzadzaniaKontami;

public class Admin extends Account {
    private int level;

    public Admin(int id, String username, String email, String password, int level) {
        super(id, username, email, password);
        this.level = level;
    }

    @Override
    public void showProfile() {
        System.out.println("Admin [ID =" + id + ", Użytkownik =" + username + ", email=" + email + ", Poziom =" + level + "]");
    }
}
