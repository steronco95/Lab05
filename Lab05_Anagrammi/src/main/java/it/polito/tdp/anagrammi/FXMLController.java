/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInserisciParola"
    private TextField txtInserisciParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="lblAnaCorr"
    private Label lblAnaCorr; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnaCorretti"
    private TextArea txtAnaCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="lblAnaErr"
    private Label lblAnaErr; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrori"
    private TextArea txtErrori; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCalcolo(ActionEvent event) {

    	txtAnaCorretti.clear();
    	txtErrori.clear();
    	model.puliscitutto();
    	String anagramma = txtInserisciParola.getText();
    	
    	
    	try {
    		model.setAnagrammi(anagramma);
    		model.verificaAnagrammi();
    		
    		txtAnaCorretti.appendText(model.getCorretti());
    		txtErrori.appendText(model.getErrati());
    		return;
    	}catch(NullPointerException e ) {
    		txtAnaCorretti.appendText(e.getMessage());
    		return;
    	}catch(java.lang.OutOfMemoryError e) {
    		
    		txtAnaCorretti.appendText("anagramma troppo lungo da calcolare!");
    		return;
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtAnaCorretti.clear();
    	txtErrori.clear();
    	model.puliscitutto();
    	return;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInserisciParola != null : "fx:id=\"txtInserisciParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblAnaCorr != null : "fx:id=\"lblAnaCorr\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnaCorretti != null : "fx:id=\"txtAnaCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblAnaErr != null : "fx:id=\"lblAnaErr\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		
		this.model = model;
	}
}
