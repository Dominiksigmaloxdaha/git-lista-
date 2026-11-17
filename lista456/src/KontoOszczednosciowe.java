public class KontoOszczednosciowe extends Konto{
    public static final int LIMIT_WYPLAT = 2;
    private double oprocentowanie;
    private int liczbaWyplat;

    public KontoOszczednosciowe(String wlasciciel, double saldoPoczatkowe, double oprocentowanie){
        super(wlasciciel, saldoPoczatkowe);
        this.oprocentowanie = (oprocentowanie >= 0 && oprocentowanie <= 0.10) ? oprocentowanie : 0.0;
        liczbaWyplat = 0;
    }
    public KontoOszczednosciowe(String wlasciciel, double oprocentowanie) {
        super(wlasciciel);
        this.oprocentowanie = (oprocentowanie >= 0 && oprocentowanie <= 0.10) ? oprocentowanie : 0.0;
        liczbaWyplat = 0;
    }
    public double getOprocentowanie() {
        return oprocentowanie;
    }
    public int getLiczbaWyplat() {
        return liczbaWyplat;
    }
    public void naliczOdsetki() {
        if (getSaldo() > 0) {
            double noweSaldo = getSaldo() + (getSaldo() * oprocentowanie);
            ustawSaldo(noweSaldo);
        }
    }
    @Override
    public boolean czyMozewyplacic(double kwota)  {
        return liczbaWyplat < LIMIT_WYPLAT && super.czyMozewyplacic(kwota);
    }

    @Override
    public boolean wyplac(double kwota)  {
        if (super.wyplac(kwota)) {
            liczbaWyplat++;
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return String.format("%s | oszczednosciowe %.2f%%, wyplat: %d/%d",
                super.toString(), oprocentowanie*100, liczbaWyplat, LIMIT_WYPLAT);
    }
}
