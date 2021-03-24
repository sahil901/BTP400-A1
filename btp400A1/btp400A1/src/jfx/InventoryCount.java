package jfx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InventoryCount extends btp400.a1.InventoryManager {

    @FXML
    private Button back;
    
    @FXML
    private Button clear;

    @FXML
    private Button check;

    @FXML
    private TextField materialname;

    @FXML
    private TextField displayArea;

    @FXML
    void backClicked(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("MainPage.fxml");

    }

    @FXML
    void checkClicked(ActionEvent event) {
    	if(materialname.getText().toString().toUpperCase().equals("BOLT"))
    	displayArea.setText(getInvCountOf("BOLT"));
    	else if (materialname.getText().toString().toUpperCase().equals("SCREWS"))
    	displayArea.setText(getInvCountOf("SCREWS"));
    	else if (materialname.getText().toString().toUpperCase().equals("AXELS"))
    	displayArea.setText(getInvCountOf("AXELS"));
    	else if (materialname.getText().toString().toUpperCase().equals("DOORS"))
        	displayArea.setText(getInvCountOf("DOORS"));
    	else if (materialname.getText().toString().toUpperCase().equals("BRAKES"))
        	displayArea.setText(getInvCountOf("BRAKES"));
    	else if (materialname.getText().toString().toUpperCase().equals("WINDSHIELDS"))
        	displayArea.setText(getInvCountOf("WINDSHIELDS"));
    	else if (materialname.getText().toString().toUpperCase().equals("GEARBOX"))
        	displayArea.setText(getInvCountOf("GEARBOX"));
    	else if (materialname.getText().toString().toUpperCase().equals("SENSORS"))
        	displayArea.setText(getInvCountOf("SENSORS"));
    	else if (materialname.getText().toString().toUpperCase().equals("PAINT"))
        	displayArea.setText(getInvCountOf("PAINT"));
    	else if (materialname.getText().toString().toUpperCase().equals("TRANSMISSION"))
        	displayArea.setText(getInvCountOf("TRANSMISSION"));
    	else if (materialname.getText().isEmpty())
        	displayArea.setText("ENTER MATERIAL NAME!!");
    	else 
    		displayArea.setText("WRONG MATERIAL NAME!!");
    	}
    
    @FXML
    void clearClicked(ActionEvent event) {
    	displayArea.setText("");
    	materialname.setText("");

    }
}
    	 
    

