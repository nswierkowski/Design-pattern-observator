package Main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;


import Obserwator.*;
import Obserwowany.*;

public class Main {

	JFrame ramka;
	JPanel panel1;
	JTextField tekst1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JTextField tekst2;
	JTextField tekst3;
	JTextField tekst4;
	JButton przycisk1;
	JButton przycisk2;
	CentrumAlarmowe ca;
	PogotowieRatunkowe pr;
	Policja p;
	StrazPozarna sp;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.Rysuj();
		
		m.ca = new CentrumAlarmowe();
		m.pr = new PogotowieRatunkowe();
		m.p = new Policja();
		m.sp = new StrazPozarna();
		
		m.pr.sluzbaPubliczna(m.ca);
		m.p.sluzbaPubliczna(m.ca);
		m.sp.sluzbaPubliczna(m.ca);
		
		m.ca.dodajSluzbe(m.sp);
		m.ca.dodajSluzbe(m.p);
		m.ca.dodajSluzbe(m.pr);
	}

	public void Rysuj() {
		ramka = new JFrame();
		panel1 = new JPanel();
		tekst1 = new JTextField(50);
		label2 = new JLabel(" Numer: ");
		label3 = new JLabel(" Stopień zagrożenia (1-3): ");
		label4 = new JLabel(" Co się stało: ");
		tekst2 = new JTextField(10);
		tekst3 = new JTextField(10);
		tekst4 = new JTextField(10);
		przycisk1 = new JButton("Zgłoś");
		przycisk2 = new JButton("Wyczyść");
		
		ramka.getContentPane().add(panel1);
		panel1.setLayout(new GridLayout(4, 2));
		przycisk1.addActionListener(new Zgłos());
		przycisk2.addActionListener(new Wyczyść());
		
		panel1.add(label2);
		panel1.add(tekst2);
		
		panel1.add(label3);
		panel1.add(tekst3);
		
		panel1.add(label4);
		panel1.add(tekst4);
		
		panel1.add(przycisk1);
		panel1.add(przycisk2);
		
		
		ramka.setTitle("Centrum alarmowe");
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramka.pack();
		ramka.setResizable(false);
		ramka.setVisible(true);
		ramka.setSize(400, 200);
	}
	
	class Zgłos implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			String a = tekst2.getText();
			String b = tekst3.getText();
			String nazwaWydarzenia = tekst4.getText();
			try {
				int numer = Integer.parseInt(a);
				int stopienZagrozenia = Integer.parseInt(b);
				ca.noweZgloszenie(numer, stopienZagrozenia, nazwaWydarzenia);
			}
			catch (NumberFormatException e1){
				JOptionPane.showMessageDialog(null, "Nieprawidłowy format liczby", "", JOptionPane.ERROR_MESSAGE);
			}

		}
	}
	
	class Wyczyść implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			tekst1.setText("");
			tekst2.setText("");
			tekst3.setText("");
			tekst4.setText("");
		}
	}
}
