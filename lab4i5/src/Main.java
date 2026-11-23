import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Konto konto1 = new Konto("Anna Kowalska", 1000.0);
        KontoOszczednosciowe konto2 = new KontoOszczednosciowe("Jan Nowak", 1000.0, 0.02);
        KontoZDebetem konto3 = new KontoZDebetem("Firma XYZ", 500.0);

        konto2.naliczOdsetki();
        System.out.println(konto2);

        wykonajOperacje(konto3.wplac(100), "Wplata 100 na konto nr 3");
        wykonajOperacje(konto3.wyplac(300), "Wyplata 300 z konta nr 3");
        wykonajOperacje(konto3.wyplac(400), "Wyplata 400 z konta nr 3");
        wykonajOperacje(konto2.wyplac(100), "Wyplata 100 z konta nr 2");
        wykonajOperacje(konto2.wyplac(100), "Wyplata 100 z konta nr 2");
        wykonajOperacje(konto2.wyplac(100), "Wyplata 100 z konta nr 2");

        Konto konto3JakoKonto = konto3;
        boolean okWyplata250 = konto3JakoKonto.wyplac(250);
        System.out.println("Wyplata 250 z konta nr 3 (zmienna typu Konto): " + (okWyplata250 ? "OK" : "ODMOWA"));

        System.out.println(konto1);
        System.out.println(konto2);
        System.out.println(konto3);
        System.out.printf(Locale.forLanguageTag("pl"), "Dostepne srodki konta nr 3: %.2f%n", konto3.dostepneSrodki());
        System.out.println("Konto nr 2 ma wiecej niz konto nr 3: " + (konto2.maWiecejNiz(konto3) ? "TAK" : "NIE"));
        System.out.println("Liczba kont: " + Konto.getLiczbaKont());
    }

    private static void wykonajOperacje(boolean sukces, String nazwaOperacji) {
        System.out.println(nazwaOperacji + ": " + (sukces ? "OK" : "ODMOWA"));
    }
}