package guiGetraenkemarkt;

import business.Getraenk;
import business.GetrankeModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observer;

public class GetraenkeView implements Observer{

	private GetrankControl control;
	private GetrankeModel model;
	
	
	//---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblArtikelnummer 			= new Label("Artikelnummer:");
    private Label lblEinkaufspreis   		= new Label("Einkaufspreis:");
    private Label lblVerkaufspreis  	 	= new Label("Verkaufspreis:");
    private Label lblMitAlkohol   			= new Label("mit Alkohol:");
    private Label lblBehaeltnisse  			= new Label("Behaeltnisse:");
    private TextField txtArtikelnummer 	 	= new TextField();
    private TextField txtEinkaufspreis		= new TextField();
    private TextField txtVerkaufspreis		= new TextField();
    private TextField txtMitAlkohol			= new TextField();
    private TextField txtBehaeltnisse	 	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
	public GetraenkeView(GetrankControl control, GetrankeModel model, Stage primaryStage) {
		this.control = control;
		this.model = model;
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung eines Getraenkemarktes");
    	primaryStage.show();
    	this.model.addObserver(this);
    	this.initKomponenten();
		this.initListener();
		
	}
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblArtikelnummer.setLayoutX(20);
    	lblArtikelnummer.setLayoutY(90);
    	lblEinkaufspreis.setLayoutX(20);
    	lblEinkaufspreis.setLayoutY(130);
    	lblVerkaufspreis.setLayoutX(20);
    	lblVerkaufspreis.setLayoutY(170);
    	lblMitAlkohol.setLayoutX(20);
    	lblMitAlkohol.setLayoutY(210);
    	lblBehaeltnisse.setLayoutX(20);
    	lblBehaeltnisse.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblArtikelnummer, lblEinkaufspreis, lblVerkaufspreis,
       		lblMitAlkohol, lblBehaeltnisse);
    
    	// Textfelder
     	getTxtArtikelnummer().setLayoutX(170);
    	getTxtArtikelnummer().setLayoutY(90);
    	getTxtArtikelnummer().setPrefWidth(200);
    	getTxtEinkaufspreis().setLayoutX(170);
    	getTxtEinkaufspreis().setLayoutY(130);
    	getTxtEinkaufspreis().setPrefWidth(200);
    	getTxtVerkaufspreis().setLayoutX(170);
    	getTxtVerkaufspreis().setLayoutY(170);
    	getTxtVerkaufspreis().setPrefWidth(200);
      	getTxtMitAlkohol().setLayoutX(170);
    	getTxtMitAlkohol().setLayoutY(210);
    	getTxtMitAlkohol().setPrefWidth(200);
    	getTxtBehaeltnisse().setLayoutX(170);
    	getTxtBehaeltnisse().setLayoutY(250);
    	getTxtBehaeltnisse().setPrefWidth(200);
      	pane.getChildren().addAll( 
     		getTxtArtikelnummer(), getTxtEinkaufspreis(), getTxtVerkaufspreis(),
     		getTxtMitAlkohol(), getTxtBehaeltnisse());
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
       // btnAnzeige.setLayoutX(400);
        //btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    control.nehmeGetraenkAuf();
            }
	    });
	    /*btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            update();
	        } 
   	    });
   	    */
	    mnItmCsvImport.setOnAction((e)->control.leseAusDatei("csv"));
	    mnItmTxtImport.setOnAction((e)->control.leseAusDatei("txt"));
	    mnItmCsvExport.setOnAction((e)->control.schreibeBahnhoefeInCsvDatei());
    }
   
   public void zeigeInformationsfensterAn(String meldung){
   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information", meldung).zeigeMeldungsfensterAn();
   }
   	
   
   public void zeigeFehlermeldungsfensterAn(String meldung){
      	new MeldungsfensterAnzeiger(AlertType.ERROR,"Fehler", meldung).zeigeMeldungsfensterAn();
   }

public TextField getTxtBehaeltnisse() {
	return txtBehaeltnisse;
}

public void setTxtBehaeltnisse(TextField txtBehaeltnisse) {
	this.txtBehaeltnisse = txtBehaeltnisse;
}

public TextField getTxtMitAlkohol() {
	return txtMitAlkohol;
}

public void setTxtMitAlkohol(TextField txtMitAlkohol) {
	this.txtMitAlkohol = txtMitAlkohol;
}

public TextField getTxtVerkaufspreis() {
	return txtVerkaufspreis;
}

public void setTxtVerkaufspreis(TextField txtVerkaufspreis) {
	this.txtVerkaufspreis = txtVerkaufspreis;
}

public TextField getTxtEinkaufspreis() {
	return txtEinkaufspreis;
}

public void setTxtEinkaufspreis(TextField txtEinkaufspreis) {
	this.txtEinkaufspreis = txtEinkaufspreis;
}

public TextField getTxtArtikelnummer() {
	return txtArtikelnummer;
}

public void setTxtArtikelnummer(TextField txtArtikelnummer) {
	this.txtArtikelnummer = txtArtikelnummer;
}

/*private void zeigeBahnhoefeAn(){
	if(model.getGetraenk() != null){
		txtAnzeige.setText(
			model.getGetraenk().gibGetraenkZurueck(' '));
	}
	else{
		zeigeInformationsfensterAn("Bisher wurde keine Getraenk aufgenommen!");
	}
}
*/
@Override
public void update() {
	
	if(model.getGetraenk().size()>0){
		StringBuffer text = new StringBuffer();
		for(Getraenk getraenk : model.getGetraenk()) {
			text.append(getraenk.gibGetraenkZurueck(' ')).append("\n");
		}
		
		
		txtAnzeige.setText(text.toString());
	}
	else{
		zeigeInformationsfensterAn("Bisher wurde keine Getraenk aufgenommen!");
	}
}    

}
