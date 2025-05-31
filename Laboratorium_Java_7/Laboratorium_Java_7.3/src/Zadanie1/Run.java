package Zadanie1;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Run {
    public Run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Wpisz Tekst");
        String tekst = sc.nextLine();

        tekst = tekst.toLowerCase().replaceAll("[^a-ząćęłńóśźż0-9 ]", "");
        String[]slowo = tekst.split(" ");

        Map<String ,Integer> map = new HashMap<>();
        for(String slowo1 : slowo){
            map.put(slowo1,map.getOrDefault(slowo1,0)+1);
        }
        System.out.println("Występujące słowa");
        for(Map.Entry<String ,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}