package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	
	Model model = new Model();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParolaInserita;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private Button btnReset;
    
    private TextArea txtSbagliate;

    public void setModel(Model model) {
    	this.model = model;
    }
    
    @FXML
    void calcolaAnagrammi(ActionEvent event) {
    	txtCorretti.clear();
    	//txtSbagliate.clear();
    	
    	String input = txtParolaInserita.getText();
    	model.genera(input);
    	
    	for(String s : model.getGiuste()) {
    		txtCorretti.appendText(s+"\n");
    	}
    	
    	for(String s : model.getSbagliate()) {
    		txtSbagliate.appendText(s+"\n");
    	}
    }

    @FXML
    void reset(ActionEvent event) {

    }

    void initialize() {
        assert txtParolaInserita != null : "fx:id=\"txtParolaInserita\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtSbagliate != null : "fx:id=\"txtSbagliate\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}

