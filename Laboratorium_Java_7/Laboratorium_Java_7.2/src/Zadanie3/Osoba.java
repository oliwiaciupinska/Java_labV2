package Zadanie3;

import java.util.Objects;


public class Osoba extends Dane {

    public Osoba(int ID, int wiek, String imie) {
        super(ID, wiek, imie);
    }

    @Override
    public String toString() {
        return "Dane użytkownika to  ID: " + ID + " , wiek " + wiek + " oraz imie  " + imie;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoba)) return false;
        Osoba osoba = (Osoba) o;
        return ID == osoba.ID &&
                wiek == osoba.wiek &&
                Objects.equals(imie, osoba.imie);
    }


    @Override
    public int hashCode() {
        return Objects.hash(ID, wiek, imie);
    }
}