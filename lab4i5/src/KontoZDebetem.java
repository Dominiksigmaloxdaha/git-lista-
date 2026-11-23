import java.util.Locale;

public class KontoZDebetem extends Konto {
    private double limitDebetu;

    public KontoZDebetem(String wlasciciel, double limitDebetu) {
        super(wlasciciel);
        this.limitDebetu = limitDebetu < 0 ? 0.0 : limitDebetu;
    }

    public double getLimitDebetu() {
        return limitDebetu;
    }

    public double dostepneSrodki() {
        return getSaldo() + limitDebetu;
    }

    @Override
    public boolean czyMozewyplacic(double kwota) {
        return kwota > 0 && kwota <= MAKS_WYPLATA && kwota <= dostepneSrodki();
    }

    @Override
    public String toString() {
        return String.format(Locale.forLanguageTag("pl"),
                "%s | z debetem, limit %.2f",
                super.toString(), limitDebetu);
    }
}