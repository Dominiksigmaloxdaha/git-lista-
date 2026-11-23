import java.util.Locale;

public class Konto {
    private final int numer;
    private final String wlasciciel;
    private double saldo;
    private int liczbaOperacji;

    private static int liczbaKont = 0;

    public static final double MAKS_WYPLATA = 5000;

    public Konto(String wlasciciel, double saldoPoczatkowe) {
        liczbaKont++;
        this.numer = liczbaKont;

        if (wlasciciel == null || wlasciciel.trim().isEmpty()) {
            this.wlasciciel = "nieznany";
        } else {
            this.wlasciciel = wlasciciel;
        }

        this.saldo = saldoPoczatkowe;
        this.liczbaOperacji = 0;
    }

    public Konto(String wlasciciel) {
        this(wlasciciel, 0.0);
    }

    protected void ustawSaldo(double noweSaldo) {
        this.saldo = noweSaldo;
    }

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

    public boolean wplac(double kwota) {
        if (kwota <= 0) {
            return false;
        }
        saldo += kwota;
        liczbaOperacji++;
        return true;
    }

    public boolean czyMozewyplacic(double kwota) {
        return kwota > 0 && kwota <= saldo && kwota <= MAKS_WYPLATA;
    }

    public boolean wyplac(double kwota) {
        if (czyMozewyplacic(kwota)) {
            saldo -= kwota;
            liczbaOperacji++;
            return true;
        }
        return false;
    }

    public boolean maWiecejNiz(Konto inneKonto) {
        if (inneKonto == null) {
            return false;
        }
        return this.saldo > inneKonto.saldo;
    }

    @Override
    public String toString() {
        return String.format(Locale.forLanguageTag("pl"),
                "Konto nr %d [%s] saldo: %.2f | operacji: %d",
                numer, wlasciciel, saldo, liczbaOperacji);
    }
}