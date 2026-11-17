public class Konto {
    // 2a. Pola prywatne
    private final int numer; // numer nie zmienia się po utworzeniu (final)
    private final String wlasciciel; // właściciel nie zmienia się po utworzeniu (final)
    private double saldo;
    private int liczbaOperacji;

    // 2b. Prywatne pole statyczne zliczające konta
    private static int liczbaKont = 0;

    // 3c. Publiczna stała klasy
    public static final double MAKS_WYPLATA = 5000;
    // Wyjaśnienie: Stała (final) nie zmienia swojej wartości w czasie działania programu,
    // więc jej publiczna modyfikacja jest bezpieczna. Saldo natomiast ulega zmianie
    // i musi być chronione (enkapsulacja), aby nie dopuścić do niekontrolowanego stanu.

    // 2e. Pierwszy konstruktor (własciciel, saldoPoczatkowe)
    public Konto(String wlasciciel, double saldoPoczatkowe) {
        // 2b. Zwiększ licznik i nadaj unikalny numer konta (1, 2, 3...)
        liczbaKont++;
        this.numer = liczbaKont;

        // 2c. Jeśli właściciel jest pusty albo składa się z samych spacji, zapisz "nieznany"
        if (wlasciciel == null || wlasciciel.trim().isEmpty()) {
            this.wlasciciel = "nieznany";
        } else {
            this.wlasciciel = wlasciciel;
        }

        this.saldo = saldoPoczatkowe;
        this.liczbaOperacji = 0; // Początkowo 0 operacji zgodnie z treścią
    }

    // 2e. Drugi konstruktor (wlasciciel) – saldo początkowe traktuj jako 0
    // Konstruktor ma wywołać pierwszy konstruktor, a ustawienie salda początkowego to nie operacja.
    public Konto(String wlasciciel) {
        this(wlasciciel, 0.0);
    }

    // 3a. Gettery do odczytu danych (brak setterów dla salda i liczby operacji)
    public int getNumer() {
        return numer;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getLiczbaOperacji() {
        return liczbaOperacji;
    }

    public static int getLiczbaKont() {
        return liczbaKont;
    }

    /*
     * 3b. Dlaczego nie udostępniamy publicznego settera dla salda ani liczby operacji?
     * Ponieważ naruszałoby to zasady enkapsulacji (hermetyzacji). Zmiany stanu konta
     * (wpłaty, wypłaty) muszą podlegać rygorystycznym regułom i walidacjom biznesowym
     * (np. brak ujemnych wypłat, limit MAKS_WYPLATA), a liczba operacji musi być aktualizowana
     * automatycznie. Pozwolenie na zewnętrzną, bezpośrednią modyfikację doprowadziłoby
     * do niespójności danych.
     */

    // 4a. Metoda wplac(kwota)
    public boolean wplac(double kwota) {
        if (kwota <= 0) {
            return false;
        }
        saldo += kwota;
        liczbaOperacji++;
        return true;
    }

    // 4b. Metoda czyMozewyplacic(kwota) – sprawdza warunki bez modyfikacji stanu
    public boolean czyMozewyplacic(double kwota) {
        return kwota > 0 && kwota <= saldo && kwota <= MAKS_WYPLATA;
    }

    // 4c. Metoda wyplac(kwota) – korzysta z czyMozewyplacic
    public boolean wyplac(double kwota) {
        if (czyMozewyplacic(kwota)) {
            saldo -= kwota;
            liczbaOperacji++;
            return true;
        }
        return false;
    }

    // 4d. Metoda maWiecejNiz(inneKonto)
    public boolean maWiecejNiz(Konto inneKonto) {
        if (inneKonto == null) {
            return false;
        }
        return this.saldo > inneKonto.saldo;
    }

    // 4e. Nadpisanie metody toString() dla czytelnego opisu obiektu
    @Override
    public String toString() {
        // Formatowanie kwoty do dwóch miejsc po przecinku (zgodnie z oczekiwanym wynikiem)
        return String.format("Konto nr %d [%s] saldo: %.2f | operacji: %d",
                numer, wlasciciel, saldo, liczbaOperacji);
    }
}
