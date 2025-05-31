package Zadanie2;

public class Prostokat extends Figura implements IFigury {
    float a, b;
    Punkt p;

    public Prostokat(float a, float b, Punkt p){
        this.a = a;
        this.b = b;
        this.p = p;
    }

    public String opis(){
        return "Obiekt klasy Prostokat";
    }

    public void skaluj(float skala){
        a *= skala;
        b *= skala;
    }

    public float getPowierzchnia(){
        return a * b;
    }

    public boolean wPolu(Punkt punkt){
        return punkt.x >= p.x && punkt.x <= (p.x + a) &&
                punkt.y >= p.y && punkt.y <= (p.y + b);
    }
}
