package guiWarenuebersicht;

import business.GetrankeModel;
import javafx.stage.Stage;

public class WarenuebersichtControl {

	private WarenuebersichtView warenuebersichtView;
	private GetrankeModel getraenkeModel;
	
	
	public WarenuebersichtControl(Stage primaryStage){
		this.getraenkeModel = GetrankeModel.getInstacne(); 		
		this.setWarenuebersichtView(new WarenuebersichtView(this, primaryStage,getraenkeModel));
}


	public WarenuebersichtView getWarenuebersichtView() {
		return warenuebersichtView;
	}


	public void setWarenuebersichtView(WarenuebersichtView warenuebersichtView) {
		this.warenuebersichtView = warenuebersichtView;
	}

}
