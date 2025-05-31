package Zadanie3;

public abstract class Dane {

    protected int ID;
    protected int wiek;
    protected String imie;

    public Dane(int ID, int wiek, String imie) {
        this.ID = ID;
        this.wiek = wiek;
        this.imie = imie;
    }

    public int getID() {
        return ID;
    }



    public int getWiek() {
        return wiek;
    }



    public String getImie() {
        return imie;
    }

    @Override
    public String toString() {
        return "Dane użytkownika to  ID: " + ID + " , wiek " + wiek + " oraz imie  " + imie;

    }

}
