package fileCreators;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcereteTextReaderProduct extends ReaderProduct{
	private BufferedReader ein;

	public ConcereteTextReaderProduct() {
		try {
		 ein = new BufferedReader(new FileReader("Getraenk.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] ergebnisZeile = new String[5];
		String zeile = ein.readLine();
		int i = 0;
		while(i<ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = ein.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
		
	}
	

}
