package Zadanie_Lab_08;



public class Silnia {
    public static double silnia(int n) throws BlednaWartoscDlaSilniException {
        if (n < 0) {
            throw new BlednaWartoscDlaSilniException("Nie można obliczyć silni z liczby ujemnej.");
        }
        double wynik1 = 1;
        for (int i = 2; i <= n; i++) {
            wynik1 *= i ;
        }
        return wynik1;
    }

}