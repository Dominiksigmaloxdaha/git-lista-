public class Main {
    public static void main(String[] args) {

        Konto konto1 = new Konto("Anna Kowalska", 1000.0);
        Konto konto2 = new KontoOszczednosciowe("Jan Nowak",1000.0, 0.02);
        Konto konto3 = new KontoZDebetem("Firma XYZ", 500.0);

        System.out.println(konto1);
        System.out.println(konto2);
        System.out.println(konto3);



        wykonajOperacje(konto3.wplac(100), "Wplata 100 na konto nr 3");
        wykonajOperacje(konto3.wyplac(300), "Wyplata 300 z konta nr 3");
        wykonajOperacje(konto3.wyplac(400), "Wyplata 400 z konta nr 3");
        wykonajOperacje(konto2.wyplac(100), "Wyplata 100 na konto nr 2");
        wykonajOperacje(konto2.wyplac(100), "Wyplata 100 na konto nr 2");
        wykonajOperacje(konto2.wyplac(100), "Wyplata 100 z konta nr 2");
        wykonajOperacje(konto3.wyplac(250), "Wyplata 250 z konta nr 3");


        System.out.println(konto1);
        System.out.println(konto2);
        System.out.println(konto3);
        System.out.println("Liczba kont: " + Konto.getLiczbaKont());

        String czyWiecej = konto1.maWiecejNiz(konto2) ? "TAK" : "NIE";
        System.out.println("Konto nr 1 ma wiecej niz konto nr 2: " + czyWiecej);


    }


    private static void wykonajOperacje(boolean sukces, String nazwaOperacji) {
        if (sukces) {
            System.out.println(nazwaOperacji + ": OK");
        } else {
            System.out.println(nazwaOperacji + ": ODMOWA");
        }
    }
}
