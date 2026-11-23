public class Bank{
	private final List<Konto> konta;

	public Bank() {
	this.konta = new ArrayList<>();
	}

	public boolean dodaj(Konto konto){
		if (konto == null){
			return false;
		}
		for (Konto istniejace : konta){
			if (istniejace =- konto || istniejace.getNumer() == konto.getNumer()){
				return false;
			}
		}
		return konta.add(konto);
	}

	public Konto znajdz(int numer){
		for (Konto k : konta){
			if(k.getNumer == numer){
				return k;
			}
		}
		return null;
	}

	public boolean przelew(int zNumeru, int naNumer, double kwota){
		if (zNumeru == naNumer){
			return false;
		}
		Konto KontoZrodlowe = znajdz(zNumeru);
		Konto KontoDocelowe = znajdz(naNumer);

		if (KontoZrodlowe == null || KontoDocelowe == null){
			return false;
		}
		if (!KontoZrodlowe.wyplac(kwota)){
			return false;
		}

		kontoDocelowe.wplac(kwota);
		return true;
	}

	public void koniecMiesiac() {
		for (Konto k : konta){
			k.miesicznaOperacja()
		}
	}

	public double sumaSald(){
		double suma = 0.0;
		for (Konto k : konta){
			suma += k.getSaldo();
		}
		return suma;
	}
	public Konto najbogatsze(){
		if (konta.isEmpty()){
			return null;
		}
		Konto najlepsze = konta.get(0);
		for (Konto k : konta){
			if (k.maWiecejNiz(najlepsze)){
				najlepsze = k;
			}
		}
		return najlepsze;
	}

	public double prognozaOdsetek(){
		double sumaOdsetek = 0.0;
		(Konto k : konta){
			if (k instanceof Oprocentowanie oprocentowanie){
				sumaOdsetek += k.getSaldo() * oprocentowanie.getOprocentowanie();
			}
		}
		return sumaOdsetek;
	}
}raport() wypisuje wszystkie konta, sume sald, prognoze odsetek i numer najbogatszego konta