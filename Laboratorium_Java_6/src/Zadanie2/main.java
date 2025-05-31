package Zadanie2;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Kwadrat k1 = new Kwadrat(5, new Punkt(0,0));
        Prostokat p1 = new Prostokat(3, 4, new Punkt(1,1));
        Trojkat t1 = new Trojkat(6, 2);
        Okrag o1 = new Okrag(5, new Punkt(10,10));

        Figura[] tablicaFigur = new Figura[10];
        tablicaFigur[0] = k1;
        tablicaFigur[1] = p1;
        tablicaFigur[2] = t1;
        tablicaFigur[3] = o1;

        for (Figura f : tablicaFigur) {
            if (f != null) {
                System.out.println(f.opis());
            }
        }

        List<IFigury> listaFigur = new ArrayList<>();
        listaFigur.add(k1);
        listaFigur.add(p1);
        listaFigur.add(t1);
        listaFigur.add(o1);

        Punkt testPunkt = new Punkt(2,2);

        for (IFigury fig : listaFigur){
            System.out.println("Powierzchnia: " + fig.getPowierzchnia());
            System.out.println("Czy punkt w polu: " + fig.wPolu(testPunkt));
        }

        o1.przesun(5,5);
        System.out.println("Po przesunięciu: " + o1.wPolu(new Punkt(15,15)));

        scanner.close();
    }
}

