package Zadanie2;

public class Okrag extends Figura implements IFigury, RuchFigury {
    float promien;
    Punkt srodek;

    public Okrag(float promien, Punkt srodek){
        this.promien = promien;
        this.srodek = srodek;
    }

    public String opis(){
        return "Obiekt klasy Okrag";
    }

    public void skaluj(float skala){
        promien *= skala;
    }

    public float getPowierzchnia(){
        return (float)(Math.PI * promien * promien);
    }

    public boolean wPolu(Punkt p){
        float dx = p.x - srodek.x;
        float dy = p.y - srodek.y;
        return dx * dx + dy * dy <= promien * promien;
    }

    public void przesun(int x, int y){
        srodek.x += x;
        srodek.y += y;
    }
}
