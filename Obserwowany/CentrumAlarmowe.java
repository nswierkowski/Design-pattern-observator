package Obserwowany;

import java.util.ArrayList;
import java.util.List;

import Obserwator.*;

public class CentrumAlarmowe implements Centrala {

	List<SluzbyPubliczne>sluzby = new ArrayList<>();
	int numer;
	int stopienAlarmu;
	String nazwaWydarzenia;
	
	public void noweZgloszenie(int numer, int stopienAlarmu, String nazwaWydarzenia) {
		this.numer = numer;
		this.stopienAlarmu = stopienAlarmu;
		this.nazwaWydarzenia = nazwaWydarzenia;
		poinformujSluzby();
	}

	public void setNumer(int numer) {
		this.numer = numer;
	}
	
	@Override
	public void dodajSluzbe(SluzbyPubliczne sp) {
		if(sluzby.contains(sp)) System.out.println("Istnieje już taka służba publiczna");
		else sluzby.add(sp);
	}

	@Override
	public void usunSluzbe(SluzbyPubliczne sp) {
		if(sluzby.contains(sp)) sluzby.remove(sp);
		else System.out.println("Nie istnieje taka służba publiczna");
	}

	public void poinformujSluzby() {
		for(SluzbyPubliczne s : sluzby) {
			s.zgloszenie(numer, stopienAlarmu, nazwaWydarzenia);
		}
	}

}
