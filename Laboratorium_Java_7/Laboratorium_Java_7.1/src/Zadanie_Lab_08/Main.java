package Zadanie_Lab_08;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try{



            System.out.println("Podaj liczbe a oblicze z niej pierwiastek");
            String input =scanner.nextLine();
            double liczba = Double.parseDouble(input);

            if (liczba < 0) {

                throw new NegativNumberException("Liczba nie może być ujemna ");
            }
            if (liczba == 0){
                throw new ArithmeticException("Nie można dzielić przez zero");


            }
            double wynik = liczba/10;
            double pierwiastek = Math.sqrt(liczba);

            System.out.println("Wynik dzielenia 10 / " + liczba + " + " + wynik);
            System.out.println("\nPierwiastek z " + liczba + " + " + pierwiastek);

            System.out.println("\nPodaj liczbe a oblicze z niej silnie ");
            int liczba2 = Integer.parseInt(scanner.nextLine());
            double wynik1 = Silnia.silnia(liczba2);
            System.out.println("\nSilnia z " + liczba2 + " to: " + wynik1);



            System.out.print("Podaj ulicę: ");
            String ulica = scanner.nextLine();

            System.out.print("Podaj numer domu: ");
            int numerDomu = Integer.parseInt(scanner.nextLine());

            System.out.print("Podaj kod pocztowy: ");
            String kodPocztowy = scanner.nextLine();

            System.out.print("Podaj miasto: ");
            String miasto = scanner.nextLine();

            Adres adres = new Adres(ulica , numerDomu, kodPocztowy , miasto);
            System.out.println(adres);

        }



        catch(NieprawidlowyAdresException e){
            System.out.println("Błąd w adresie: " + e.getMessage());
            System.out.println("Błąd:Numer domu musi być liczba całkowita." + e.getMessage());
        }

        catch(BlednaWartoscDlaSilniException e){
            System.out.println("Błąd:" + e.getMessage());
        }
        catch(ArithmeticException e){
            System.out.println("Nie mzna dzielic przez 0");
        }
        catch(NegativNumberException e){
            System.out.println("Błąd: " + e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println("Bład: Wprowadzona dane nie sa liczba");
        } finally{
            System.out.println("Blok który zawsze się wykonuje");
        }

    }



}