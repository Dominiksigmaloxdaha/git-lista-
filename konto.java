public class Konto {public class Konto {
    // 2. Zmieniono z private na public static final zgodnie z wymaganiem stałej klasy
    public static final double MAKS_WYPLATA = 5000.0; //gdyż ma ona wartość final i nikt nie może zmienić już jej wartości

    private final int numer;
    private final String wlasciciel;
    private double saldo;
    private int liczbaOperacji;
    private static int liczbaKont = 0;

    public Konto(String wlasciciel) {
        // 3. USUNIĘTO linię "this.wlasciciel = wlasciciel;", która blokowała pole final i psuła walidację poniżej
        liczbaKont++;
        this.numer = liczbaKont;

        // 4. Zmieniono "nieznany" na "tekst nieznany" zgodnie z pierwotnym opisem zadania
        if (wlasciciel == null || wlasciciel.trim().isEmpty()){
            this.wlasciciel = "tekst nieznany";
        } else {
            this.wlasciciel = wlasciciel;
        }
        this.saldo = 0.0;
        this.liczbaOperacji = 0;
    }

    public Konto(String wlasciciel, double saldoPoczatkowe){
        this(wlasciciel);
        if (saldoPoczatkowe > 0){
            this.saldo = saldoPoczatkowe;
        }
    }

    public boolean wplac(double kwota){
        if (kwota <= 0){
            return false;
        }

        this.saldo += kwota;
        this.liczbaOperacji++;
        return true;
    }

    public boolean czyMozeWyplacic(double kwota){
        return kwota > 0 && kwota <= this.saldo && kwota <= MAKS_WYPLATA;
    }

    public boolean wyplac(double kwota){
        if (!czyMozeWyplacic(kwota)){
            return false;
        }
        this.saldo -= kwota;
        this.liczbaOperacji++;
        return true;
    }

    public boolean maWiecejNiz(Konto inneKonto){
        if (inneKonto == null){
            return false;
        }
        return this.saldo > inneKonto.saldo;
    }

    // 5. Poprawiono literówki w poniższych nazwach metod (dodano brakujące litery 'l' oraz 'b')
    public int getNumer() { return numer; }
    public String getWlasciciel() { return wlasciciel; }
    public double getSaldo() { return saldo; } //są to wrażliwe dane biznesowe
    public int getLiczbaOperacji() { return liczbaOperacji; }
    public static int getLiczbaKont() { return liczbaKont; }

    @Override
    public String toString() {
        return String.format("Konto nr %d [%s] saldo: %.2f | operacje: %d",
                this.numer, this.wlasciciel, this.saldo, this.liczbaOperacji);
    }
}

}
