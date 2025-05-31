package Zad1_Nowe;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Run {
    public void start() {
        List<String> pesels;

        try {
            pesels = Files.readAllLines(Paths.get("pesel.txt"));
        } catch (IOException e) {
            System.out.println("Błąd odczytu pesel.txt");
            return;
        }

        int kobiety = 0;
        int mezczyzni = 0;
        int lata50_80 = 0, suma50_80 = 0;
        int lata81_00 = 0, suma81_00 = 0;
        int lata01_25 = 0, suma01_25 = 0;
        int rokAktualny = LocalDate.now().getYear();

        List<String> datyUrodzenia = new ArrayList<>();

        for (String pesel : pesels) {
            if (!pesel.matches("\\d{11}")) continue;

            int rok = Integer.parseInt(pesel.substring(0, 2));
            int miesiac = Integer.parseInt(pesel.substring(2, 4));
            int dzien = Integer.parseInt(pesel.substring(4, 6));

            if (miesiac >= 1 && miesiac <= 12) {
                rok += 1900;
            } else if (miesiac >= 21 && miesiac <= 32) {
                rok += 2000;
                miesiac -= 20;
            } else if (miesiac >= 41 && miesiac <= 52) {
                rok += 2100;
                miesiac -= 40;
            }

            int plec = Character.getNumericValue(pesel.charAt(9));
            if (plec % 2 == 0) kobiety++;
            else mezczyzni++;

            try {
                LocalDate data = LocalDate.of(rok, miesiac, dzien);
                int wiek = rokAktualny - data.getYear();
                datyUrodzenia.add(data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

                if (rok >= 1950 && rok <= 1980) {
                    lata50_80++;
                    suma50_80 += wiek;
                } else if (rok >= 1981 && rok <= 2000) {
                    lata81_00++;
                    suma81_00 += wiek;
                } else if (rok >= 2001 && rok <= 2025) {
                    lata01_25++;
                    suma01_25 += wiek;
                }
            } catch (Exception ignored) {
            }
        }

        System.out.println("ZADANIE 1 – NOWA WERSJA:");
        System.out.println("Kobiety: " + kobiety + ", Mężczyźni: " + mezczyzni);
        System.out.println("1950–1980: " + lata50_80 + ", średni wiek: " + (lata50_80 == 0 ? 0 : suma50_80 / lata50_80));
        System.out.println("1981–2000: " + lata81_00 + ", średni wiek: " + (lata81_00 == 0 ? 0 : suma81_00 / lata81_00));
        System.out.println("2001–2025: " + lata01_25 + ", średni wiek: " + (lata01_25 == 0 ? 0 : suma01_25 / lata01_25));

        try {
            Files.write(Paths.get("wyniki.txt"), datyUrodzenia);
            System.out.println("Zapisano do wyniki.txt");
        } catch (IOException e) {
            System.out.println("Błąd zapisu.");
        }
    }
}
