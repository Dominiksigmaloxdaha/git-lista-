import java.util.Locale;

public class KontoOszczednosciowe extends Konto {
    private double oprocentowanie;
    private int liczbaWyplat;
    public static final int LIMIT_WYPLAT = 2;

    public KontoOszczednosciowe(String wlasciciel, double oprocentowanie) {
        super(wlasciciel);
        this.oprocentowanie = walidujOprocentowanie(oprocentowanie);
        this.liczbaWyplat = 0;
    }

    public KontoOszczednosciowe(String wlasciciel, double saldoPoczatkowe, double oprocentowanie) {
        super(wlasciciel, saldoPoczatkowe);
        this.oprocentowanie = walidujOprocentowanie(oprocentowanie);
        this.liczbaWyplat = 0;
    }

    private double walidujOprocentowanie(double wartosc) {
        if (wartosc < 0.0 || wartosc > 0.10) {
            return 0.0;
        }
        return wartosc;
    }

    public double getOprocentowanie() {
        return oprocentowanie;
    }

    public int getLiczbaWyplat() {
        return liczbaWyplat;
    }

    public void naliczOdsetki() {
        double noweSaldo = getSaldo() + (getSaldo() * oprocentowanie);
        ustawSaldo(noweSaldo);
    }

    @Override
    public boolean czyMozewyplacic(double kwota) {
        if (liczbaWyplat >= LIMIT_WYPLAT) {
            return false;
        }
        return super.czyMozewyplacic(kwota);
    }

    @Override
    public boolean wyplac(double kwota) {
        if (super.wyplac(kwota)) {
            liczbaWyplat++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format(Locale.forLanguageTag("pl"),
                "%s | oszczednosciowe %.2f%%, wyplat: %d/%d",
                super.toString(), oprocentowanie * 100.0, liczbaWyplat, LIMIT_WYPLAT);
    }
}