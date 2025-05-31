package SystemZarzadzaniaKontami;

public class Moderator extends Account {
    private int reportsHandled;

    public Moderator(int id, String username, String email, String password, int reportsHandled) {
        super(id, username, email, password);
        this.reportsHandled = reportsHandled;
    }

    @Override
    public void showProfile() {
        System.out.println("Moderator [ID =" + id + ", Użytkownik =" + username + ", email =" + email + ", Obsługiwane raporty =" + reportsHandled + "]");
    }
}
