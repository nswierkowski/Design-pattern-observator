package Obserwator;

import java.util.ArrayList;
import java.util.List;

import Obserwowany.Centrala;

public class PogotowieRatunkowe implements SluzbyPubliczne {

	private Centrala centrala;
	private int numer;
	private int stopienAlarmu;
	private String nazwaWydarzenia;
	private String reakcja;
	private String rodzajKaretki;
	
	@Override
	public void sluzbaPubliczna(Centrala centrala) {
		this.centrala = centrala;
	}

	@Override
	public void zgloszenie(int numer, int stopienAlarmu, String nazwaWydarzenia) {
		if(numer == 999 || numer == 112) {
			this.stopienAlarmu = stopienAlarmu;
			this.nazwaWydarzenia = nazwaWydarzenia;
			reakcja();
			wyswietl();
		}
	}

	@Override
	public void reakcja() {
		switch(stopienAlarmu) {		
			case 1:
				reakcja = "Wysyła karetke z podstawowym wyposażeniem";
				rodzajKaretki = "(T) transportowa";
				break;
			case 2:
				reakcja = "Wysyła karetke ze średnim wyposażeniem";
				rodzajKaretki = "(P) podstawowa";
				break;
			case 3:
				reakcja = "Wysyła karetke ze wszelkim wyposażeniem";
				rodzajKaretki = "(S) specjalistyczna";
				break;
		}
	}

	@Override
	public void wyswietl() {
		System.out.println("Stopień alarmu: " + stopienAlarmu);
		System.out.println("Nazwa zdarzenia: " + nazwaWydarzenia);
		System.out.println("Reakcja: " + reakcja);
		System.out.println("Rodzaj karetki:" +rodzajKaretki + "\n");
	}

	public String toString() {
		if(numer == 999 || numer == 112) {
			return "Reakcja: " + reakcja +"\t" + "Rodzaj karetki:" +rodzajKaretki + "\n";
		}
		else {
			return "";
		}
	}
}
