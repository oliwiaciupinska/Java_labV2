package Zadanie2;

public class Kwadrat extends Figura implements IFigury {
    float bok;
    Punkt p;

    public Kwadrat(float bok, Punkt p){
        this.bok = bok;
        this.p = p;
    }

    public String opis(){
        return "Obiekt klasy Kwadrat";
    }

    public void skaluj(float skala){
        bok *= skala;
    }

    public float getPowierzchnia(){
        return bok * bok;
    }

    public boolean wPolu(Punkt punkt){
        return punkt.x >= p.x && punkt.x <= (p.x + bok) &&
                punkt.y >= p.y && punkt.y <= (p.y + bok);
    }
}
