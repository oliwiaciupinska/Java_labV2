package SystemZarzadzaniaKontami;

public class RegularUser extends Account {
    private int postsCount;

    public RegularUser(int id, String username, String email, String password, int postsCount) {
        super(id, username, email, password);
        this.postsCount = postsCount;
    }

    @Override
    public void showProfile() {
        System.out.println("Zwyczajny użytkownik [ID = " + id + ", Użytkownik =" + username + ", Email =" + email + ", Liczba postow =" + postsCount + "]");
    }
}
