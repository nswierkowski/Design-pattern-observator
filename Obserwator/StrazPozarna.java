package Obserwator;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Obserwowany.Centrala;
import Obserwowany.CentrumAlarmowe;

public class StrazPozarna implements SluzbyPubliczne{

	private Centrala centrala;
	private int numer;
	private int stopienAlarmu;
	private String nazwaWydarzenia;
	private String reakcja;
	private List<String>wyposazenie = new ArrayList<>();
	
	public void sluzbaPubliczna(Centrala centrala) {
		this.centrala = centrala;
	}


	public void zgloszenie(int numer, int stopienAlarmu, String nazwaWydarzenia) {
		if(numer == 998 || numer == 112) {
			this.numer = numer;
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
				reakcja = "Wysyła mały wóz strażacki, z podstawowym wyposażeniem";
				wyposazenie.add("-Wąż strażacki");
				wyposazenie.add("-Drabina wysuwana");
				wyposazenie.add("-Podstawowa gaśnica");
				break;
			case 2:
				reakcja = "Wysyła średnia wóz strażacki ze średnim wyposażeniem";
				wyposazenie.add("-Wąż strażacki");
				wyposazenie.add("-Drabina wysuwana");
				wyposazenie.add("-Podstawowa gaśnica");
				wyposazenie.add("-Gaśnica śniegowa");
				break;
			default:
				reakcja = "Wysyła największy wóz strażacki z pełnym wyposażeniem i zawiadamia pogotowie o potencjalnych poszkodowanych";
				wyposazenie.add("-Wąż strażacki");
				wyposazenie.add("-Drabina wysuwana");
				wyposazenie.add("-Każdy rodzaj gaśnicy");
				if(numer != 112) pomoc();
				break;
		}
	}

	public void pomoc() {
		centrala.setNumer(999);
	}
	
	@Override
	public void wyswietl() {
		System.out.println("Stopień alarmu: " + stopienAlarmu);
		System.out.println("Nazwa zdarzenia: " + nazwaWydarzenia);
		System.out.println("Reakcja: " + reakcja);
		System.out.println("Wyposażenie wozu:");
		for(String s : wyposazenie) {
			System.out.println(s);
		}
		System.out.println();
	}

	public String toString() {
		if(numer == 998 || numer == 112) {
			return "Reakcja: " + reakcja +"\t" + "Wyposażenie wozu:" +wyposazenie;
		}
		else {
			return "";
		}
	}
	
}
