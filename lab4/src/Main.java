public class Main {
    public static void main(String[] args) {
        // 5a. Utwórz trzy konta: Anna Kowalska z saldo 1000, Jan Nowak bez saldo początkowego,
        // oraz konto, którego właściciel to same spacje, z saldem początkowym -50. Wypisz wszystkie trzy konta.
        Konto konto1 = new Konto("Anna Kowalska", 1000.0);
        Konto konto2 = new Konto("Jan Nowak");
        Konto konto3 = new Konto("   ", -50.0);

        System.out.println(konto1);
        System.out.println(konto2);
        System.out.println(konto3);

        // 5b. Odpowiedź na pytanie:
        // Przed uruchomieniem operacji: Wpłata 200 na konto nr 2 UDADA SIE (kwota dodatnia, dodaje się do salda 0).
        // Wpłata 300 z konta nr 1 -> UWAGA: w poleceniu jest napisane "wplata 300 z konta nr 1", co jest błędem słownym,
        // ale w sekcji operacji wykonuje się wypłatę lub wpłatę zgodnie z logiką (patrz wynik: "Wyplata 300 z konta nr 1: OK").

        // 5c. Wykonaj kolejno operacje, po każdej wypisując OK albo ODMOWA:
        wykonajOperacje(konto2.wplac(200), "Wplata 200 na konto nr 2");
        wykonajOperacje(konto1.wyplac(300), "Wyplata 300 z konta nr 1");
        wykonajOperacje(konto2.wyplac(500), "Wyplata 500 z konta nr 2");       // odmowa (brak środków)
        wykonajOperacje(konto2.wyplac(-50), "Wyplata -50 na konto nr 2");     // odmowa (kwota ujemna)
        wykonajOperacje(konto1.wplac(6000), "Wplata 6000 na konto nr 1");     // OK
        wykonajOperacje(konto1.wyplac(6000), "Wyplata 6000 z konta nr 1");    // odmowa (przekracza MAKS_WYPLATA = 5000)
        wykonajOperacje(konto1.wyplac(5000), "Wyplata 5000 z konta nr 1");    // OK

        // 5d. Wypisz ponownie wszystkie konta, liczbę kont oraz TAK albo NIE w zależności od tego, czy konto nr 1 ma więcej pieniędzy niż konto nr 2.
        System.out.println(konto1);
        System.out.println(konto2);
        System.out.println(konto3);
        System.out.println("Liczba kont: " + Konto.getLiczbaKont());

        String czyWiecej = konto1.maWiecejNiz(konto2) ? "TAK" : "NIE";
        System.out.println("Konto nr 1 ma wiecej niz konto nr 2: " + czyWiecej);

        // 5e. Porównaj wynik z oczekiwanym podanym na końcu listy. Muszą być identyczne.

        /*
         * ==========================================
         * 6. EKSPERYMENTY (po każdym przywróć poprawny kod)
         * ==========================================
         *
         * 6a. W programie głównym spróbuj bezpośrednio przypisać nową wartość do salda konta.
         * Kod: konto1.saldo = 5000;
         * Komunikat kompilatora: "saldo has private access in Konto" (lub błąd o niedostępności pola).
         * Wyjaśnienie: Pole 'saldo' jest prywatne (private), więc nie ma do niego dostępu spoza klasy Konto.
         *
         * 6b. Udostępnij publicznie możliwość zmiany salda. Pokaż, jak z programu głównego ustawić saldo ujemne z pominięciem kontroli w wypłacie.
         * Gdyby w klasie Konto dopisać np. `public void setSaldo(double saldo) { this.saldo = saldo; }`,
         * w Main można wpisać: `konto1.setSaldo(-9999);` co całkowicie łamie logikę biznesową aplikacji.
         *
         * 6c. Usuń modyfikator statyczny z pola liczbaKont.
         * Co mówi kompilator i dlaczego? Pola niestatyczne należą do konkretnych instancji (obiektów).
         * Jeśli pole nie jest statyczne, każdy obiekt miałby swoją własną, niezależną zmienną `liczbaKont` (zaczynającą się od nowa),
         * a próba odwołania jej przez `Konto.liczbaKont` w metodzie statycznej (np. `getLiczbaKont()`) zakończyłaby się błędem kompilacji:
         * "Non-static field 'liczbaKont' cannot be referenced from a static context".
         *
         * 6d. W dowolnej metodzie klasy Konto spróbuj zmienić numer konta. Jaki błąd się pojawia?
         * Kod (np. w konstruktorze): `this.numer = 10;`
         * Błąd kompilacji: "Cannot assign a value to final variable 'numer'".
         * Wyjaśnienie: Pole `numer` zostało zadeklarowane jako `final`, co oznacza, że można je zainicjować tylko raz (podczas tworzenia obiektu).
         *
         * 6e. Utwórz drugą zmienną i przypisz do niej konto nr 1, bez tworzenia nowego obiektu. Wpłać przez nią 100, a potem wypisz konto nr 1 i liczbę kont.
         * Ile obiektów faktycznie istnieje?
         * Kod:
         * Konto kontoKopia = konto1;
         * kontoKopia.wplac(100);
         * System.out.println(konto1);
         * System.out.println("Liczba kont: " + Konto.getLiczbaKont());
         *
         * Odpowiedź: Faktycznie nadal istnieją **3 obiekty** (zmienna `kontoKopia` to tylko druga referencja / wskaźnik wskazujący dokładnie na ten sam obiekt co `konto1`). Liczba kont (liczbaKont) nie ulegnie zwiększeniu.
         */
    }

    // Pomocnicza metoda do wypisywania statusu operacji (OK / ODMOWA)
    private static void wykonajOperacje(boolean sukces, String nazwaOperacji) {
        if (sukces) {
            System.out.println(nazwaOperacji + ": OK");
        } else {
            System.out.println(nazwaOperacji + ": ODMOWA");
        }
    }
}
