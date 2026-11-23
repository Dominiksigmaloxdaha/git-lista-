public class KontoOsobiste extends Konto {
	public static final double OPLATA_MIESIECZNA = 3.00;
	public static final double PROG_ZWOLNIENIA = 1000.0;

	public KontoOsobiste(String wlasciciel){
		super(wlasciciel);
	}

	@Override
	public void miesieczneOperacja() {
		if(getSaldo() < PROG_ZWOLNIENIA){
			wyplac(PROG_ZWOLNIENIA);
		}
	}

	@Override
	public String toString(){
		return String.format(Locale.forlanguage("pl)")
		"%s | osobiste, oplata %.2f",
		super.toString(). OPLATA_MIESIECZNA);
	}
}
