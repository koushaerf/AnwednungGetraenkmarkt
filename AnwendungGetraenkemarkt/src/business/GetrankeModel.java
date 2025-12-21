package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Vector;

import fileCreators.ConcereteCsvReaderCreator;
import fileCreators.ConcereteTextReaderCreator;
import fileCreators.ReaderCreator;
import fileCreators.ReaderProduct;
import ownUtil.Observable;
import ownUtil.Observer;


public class GetrankeModel implements Observable{
	
     private ArrayList<Getraenk> getraenke= new ArrayList<Getraenk>();
	 private static GetrankeModel instance ;
	 
	 private Vector<Observer> observers = new Vector<Observer>();
	 
	 
	 private GetrankeModel() {
		
		}
	 
	 
	 public static GetrankeModel getInstacne() {
		 if(instance==null) {
			 instance = new GetrankeModel();
			 
		 }
		 
		 return instance;
	 }


	public ArrayList<Getraenk> getGetraenk() {
		return getraenke;
	}

	public void addGetraenk(Getraenk getraenk) {
		this.getraenke.add(getraenk);
		notifyObservers();
	}
	
	 public void leseAusDatei(String typ)throws Exception{
		 ReaderCreator creator;
		 
		 if(typ.equals("csv")) {
			 creator = new ConcereteCsvReaderCreator();
		 }
		 else {
			 creator = new ConcereteTextReaderCreator();
		 }
		 
			 ReaderProduct reader = creator.factoryMethod();
			 String []zeile = reader.leseAusDatei();
			 this.getraenke.add(new Getraenk(zeile[0], 
	      				Float.parseFloat(zeile[1]), 
	      				Float.parseFloat(zeile[2]), 
	      				zeile[3], 
	      				zeile[4].split("_")));
	      				reader.schliesseDatei();
	      				notifyObservers();
			 
		 
	      	  			
	      		}
	     
		
			
		public void schreibeGetraenkeInCsvDatei()throws Exception {
				BufferedWriter aus= new BufferedWriter(new FileWriter("GetraenkeAusgabe.csv", true));
				for(Getraenk getraenk : getraenke) {
					aus.write(getraenk.gibGetraenkZurueck(';'));
				}
				aus.close();
	   			
		}


		@Override
		public void addObserver(Observer obs) {
			observers.addElement(obs);
			
		}


		@Override
		public void removeObserver(Observer obs) {
			observers.removeElement(obs);
			
		}


		@Override
		public void notifyObservers() {
			for(Observer obs : observers) {
				obs.update();
			}
			
		}

}
