package Obserwowany;

import Obserwator.SluzbyPubliczne;

public interface Centrala {

	public void noweZgloszenie(int numer, int stopienAlarmu, String nazwaWydarzenia);
	
	public void dodajSluzbe(SluzbyPubliczne sp);
	
	public void usunSluzbe(SluzbyPubliczne sp);

	public void poinformujSluzby();
	
	public void setNumer(int i);
	
}
