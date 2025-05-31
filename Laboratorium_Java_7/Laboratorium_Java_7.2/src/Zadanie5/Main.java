package Zadanie5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> PierwszaLista = new ArrayList<Integer>(List.of(23,52,32,54,32));
        List<Integer> DrugaLista = new ArrayList();

        for(int i = PierwszaLista.size() - 1; i >= 0; i--){
            DrugaLista.add(PierwszaLista.get(i));
        }
        System.out.println("Pierwsza lista" + PierwszaLista);
        System.out.println("Druga lista (Odwrócona)" + DrugaLista);
    }
}