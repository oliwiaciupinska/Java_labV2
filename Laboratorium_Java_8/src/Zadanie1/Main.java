package Zadanie1;

public class Main {
    public static void main(String[] args) {
        Swiatlo aktualne = Swiatlo.CZERWONE;
        System.out.println("Zadanie 1:");
        System.out.println(aktualne.getKomunikat());

        aktualne = Swiatlo.ZOLTE;
        System.out.println(aktualne.getKomunikat());

        aktualne = Swiatlo.ZIELONE;
        System.out.println(aktualne.getKomunikat());
    }
}

enum Swiatlo {
    CZERWONE(" Czerwone Stój!"),
    ZOLTE(" Zolte Uwaga!"),
    ZIELONE(" Zielone Jedź!");

    private final String komunikat;

    Swiatlo(String komunikat) {
        this.komunikat = komunikat;
    }

    public String getKomunikat() {
        return komunikat;
    }
}
