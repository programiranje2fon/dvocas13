package zadatak1.poslovna_logika;

import java.io.*;

public class TekstDemo {

	public String ucitajTekst(String nazivFajla) throws IOException {
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

	public void upisiTekst(String nazivFajla, String tekst) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(nazivFajla));
		out.write(tekst);
		out.close();
	}
}