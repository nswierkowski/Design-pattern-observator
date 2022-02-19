package Obserwator;

import Obserwowany.Centrala;

public interface SluzbyPubliczne {

		public abstract void sluzbaPubliczna(Centrala centrala);
	
		public abstract void zgloszenie(int numer, int stopienAlarmu, String nazwaWydarzenia);

		public abstract void reakcja();
	
		public abstract void wyswietl();
		
		public abstract String toString();
}
