package zadatak1.poslovna_logika;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TekstDemoTest {
	
	private TekstDemo tekstDemo;

	@Before
	public void setUp() throws Exception {
		tekstDemo = new TekstDemo();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void metoda_ucitajTekst() {
		String ucitaniTekst;
		try {
			upisiTekst("tekst.txt", "Ovo je neki tekst koji se nalazi u fajlu. Ovaj tekst treba ucitati i ispisati na ekranu.\n");
			ucitaniTekst = tekstDemo.ucitajTekst("tekst.txt");
			String ocekivaniTekst = "Ovo je neki tekst koji se nalazi u fajlu. Ovaj tekst treba ucitati i ispisati na ekranu.\n";
			assertEquals("Nije ucitan ocekivani tekst", ocekivaniTekst, ucitaniTekst);		
			File file = new File("tekst.txt");
			file.delete();
		} catch (IOException e) {
			fail("Greska prilikom ucitavanja fajla tekst.txt");
		}

	}
	
	@Test
	public void metoda_upisiTekst() {
		String testTekst = "Ovo je neki tekst koji treba upisati u fajl.\n";
		try {
			tekstDemo.upisiTekst("tekst2.txt", testTekst);
			String ucitaniTekst = ucitajTekst("tekst2.txt");
			assertEquals("Nije upisan ocekivani tekst", testTekst, ucitaniTekst);	
			File file = new File("tekst2.txt");
			file.delete();			
		} catch (IOException e) {
			fail("Greska prilikom pisanja u fajl tekst2.txt");
		}
	
	}	
	
	private String ucitajTekst(String nazivFajla) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(nazivFajla));
		boolean kraj = false;
		String tekst = "";
		while (!kraj) {
			String pom = in.readLine();
			if (pom == null)
				kraj = true;
			else
				tekst = tekst + pom + "\n";
		}
		in.close();
		return tekst;
	}

	private void upisiTekst(String nazivFajla, String tekst) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(nazivFajla));
		out.write(tekst);
		out.close();
	}	

}
