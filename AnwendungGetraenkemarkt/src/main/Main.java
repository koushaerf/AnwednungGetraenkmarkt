package main;

import guiGetraenkemarkt.GetrankControl;
import guiWarenuebersicht.WarenuebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new GetrankControl(primaryStage);
		Stage fensterWarenuebersicht = new Stage();
		new WarenuebersichtControl(fensterWarenuebersicht);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
