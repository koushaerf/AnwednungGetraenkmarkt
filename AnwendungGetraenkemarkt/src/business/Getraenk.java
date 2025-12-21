package business;

public class Getraenk {
	
    private String artikelnummer;
    private float einkaufspreis;
    private float verkaufspreis;
    private String mitAlkohol;
    private String[] behaeltnisse;
    
    public Getraenk(String artikelnummer, float einkaufspreis, float verkaufspreis,String mitAlkohol, String[] behaeltnisse){
    	
    	this.artikelnummer = artikelnummer;
      	this.einkaufspreis = einkaufspreis;
       	this.verkaufspreis = verkaufspreis;
       	this.mitAlkohol = mitAlkohol;
       	this.behaeltnisse = behaeltnisse;
       	
       	if(this.artikelnummer==null) {
		throw new IllegalArgumentException("Artikelnummer darf nicht null sein");
	}
    }

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public float getEinkaufspreis() {
		return einkaufspreis;
	}

	public void setEinkaufspreis(float einkaufspreis) {
		this.einkaufspreis = einkaufspreis;
	}

	public float getVerkaufspreis() {
		return verkaufspreis;
	}

	public void setVerkaufspreis(float verkaufspreis) {
		this.verkaufspreis = verkaufspreis;
	}

	public String getMitAlkohol() {
		return mitAlkohol;
	}

	public void setMitAlkohol(String mitAlkohol) {
		this.mitAlkohol = mitAlkohol;
	}

	public String[] getBehaeltnisse() {
		return behaeltnisse;
	}

	public void setBehaeltnisse(String[] behaeltnisse) {
		this.behaeltnisse = behaeltnisse;
	}
	
 	public String getBehaeltnisAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getBehaeltnisse().length - 1; i++) {
			ergebnis = ergebnis + this.getBehaeltnisse()[i] + trenner; 
		}
		return ergebnis	+ this.getBehaeltnisse()[i];
	}
	
	public String gibGetraenkZurueck(char trenner){
  		return this.getArtikelnummer() + trenner 
  			+ this.getEinkaufspreis() + trenner
  			+ this.getVerkaufspreis() + trenner
  		    + this.getMitAlkohol() + trenner + "\n"
  		    + this.getBehaeltnisAlsString(trenner) + "\n";
  	}
}

