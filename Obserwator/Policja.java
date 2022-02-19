package Obserwator;

import Obserwowany.Centrala;

public class Policja implements SluzbyPubliczne{

	private Centrala centrala;
	private int numer;
	private int stopienAlarmu;
	private String nazwaWydarzenia;
	private String reakcja;
	private String kara;
	
	@Override
	public void sluzbaPubliczna(Centrala centrala) {
		this.centrala = centrala;
	}

	@Override
	public void zgloszenie(int numer, int stopienAlarmu, String nazwaWydarzenia) {
		if(numer == 997 || numer == 112) {
			this.numer = numer;
			this.stopienAlarmu = stopienAlarmu;
			this.nazwaWydarzenia = nazwaWydarzenia;
			reakcja();
			kara();
			wyswietl();
		}
	}

	@Override
	public void reakcja() {
		switch(stopienAlarmu){
		case 1: 
			reakcja = "Wysyła radiowóz z dwoma policjentami";
			break;
		case 2:
			reakcja = "Wysyła radiowozy z większą liczbą policjantów";
			break;
		default:
			reakcja = "Wysyła brygade antyterrorystyczną i powiadamia pogotowie ratunkowe o sytuacji";
			if(numer != 112) pomoc();
			break;
		}
	}

	public void pomoc() {
		centrala.setNumer(999);
	}
	
	public void kara() {
		switch(stopienAlarmu){
			case 1: 
				kara = "Mandat do wysokości 2000 złoty";
				break;
			case 2:
				kara = "Mandat do wysokości 5000 złoty lub areszt";
				break;
			case 3:
				kara = "Natychmiastowe aresztowanie";
				break;	
			default:
				kara = "Nieznana";
				break;
		}
	}
	
	@Override
	public void wyswietl() {
		System.out.println("Stopień alarmu: " + stopienAlarmu);
		System.out.println("Nazwa zdarzenia: " + nazwaWydarzenia);
		System.out.println("Reakcja: " + reakcja);
		System.out.println("Potencjalna kara: " +kara + "\n");
	}

	public String toString() {
		if(numer == 997 || numer == 112) {
			return "Reakcja: " + reakcja +"\t" + "Potencjalna kara: " +kara + "\n";
		}
		else {
			return "";
		}
	}
	
}

