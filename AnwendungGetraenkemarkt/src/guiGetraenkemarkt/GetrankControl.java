package guiGetraenkemarkt;


import java.io.IOException;

import business.Getraenk;
import business.GetrankeModel;
import javafx.stage.Stage;

public class GetrankControl {
	
	private GetraenkeView view;
	private GetrankeModel model;
	
	public GetrankControl(Stage primaryStage) {
		this.model = GetrankeModel.getInstacne();
		this.view = new GetraenkeView(this, model, primaryStage);
	}
	
	public void nehmeGetraenkAuf(){
    	try{ 
    		model.addGetraenk(new Getraenk(
    			view.getTxtArtikelnummer().getText(), 
   	            Float.parseFloat(view.getTxtEinkaufspreis().getText()),
   	            Float.parseFloat(view.getTxtVerkaufspreis().getText()),
   	        	view.getTxtMitAlkohol().getText(),
    		    view.getTxtBehaeltnisse().getText().split(";")));
    		//view.zeigeInformationsfensterAn("Das Getraenk wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
	
	
	public void schreibeBahnhoefeInCsvDatei() {
		
		try {
			model.schreibeGetraenkeInCsvDatei();
   			//view.zeigeInformationsfensterAn("Die Getraenke wurden gespeichert!");
		}	
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	
	 public void leseAusDatei(String typ){
	    	try {
	      		if("csv".equals(typ)){
	      			model.leseAusDatei(typ);
	      	  			//view.zeigeInformationsfensterAn(
	      	  	   			//"Der Getraenk wurde gelesen!");
	      		}
	       		else{
	       			model.leseAusDatei(typ);
		   			//view.zeigeInformationsfensterAn("wurede gelesen!");
		   		}
			}
			catch(IOException exc){
				view.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
				exc.printStackTrace();
			}
			catch(Exception exc){
				view.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
				exc.printStackTrace();
			}
		}
		
	

}
