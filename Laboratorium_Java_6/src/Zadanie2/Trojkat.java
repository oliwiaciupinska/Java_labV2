package Zadanie2;

public class Trojkat extends Figura implements IFigury {
    float podstawa, wysokosc;

    public Trojkat(float podstawa, float wysokosc){
        this.podstawa = podstawa;
        this.wysokosc = wysokosc;
    }

    public String opis(){
        return "Obiekt klasy Trojkat";
    }

    public void skaluj(float skala){
        podstawa *= skala;
        wysokosc *= skala;
    }

    public float getPowierzchnia(){
        return (podstawa * wysokosc) / 2;
    }

    public boolean wPolu(Punkt p){
        return false; // uproszczone
    }
}
