package jfx;

import java.io.IOException;

import btp400.a1.Material;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainPage extends btp400.a1.InventoryManager{

    @FXML
    private Button logout;
    
    @FXML
    private Button cars;

    @FXML
    private Button clear;

    @FXML
    private Button authors;
    
    @FXML
    private Button jobs;

    @FXML
    private Button inventorycount;

    @FXML
    private Button inventory;

    @FXML
    private TextArea displayArea;

    @FXML
    void inventoryClicked(ActionEvent event) {
    	String fInv = " " ;
    	//for( Material e :fullInventory) {
    	for( int i = 0; i < fullInventory.size(); ++i) {
    		
    		//displayArea.setText("\nName: "+ e.getName() + ", Quantity: "+ e.getQuantity());
    		displayArea.setText(fInv += "Material Name: "+fullInventory.get(i).getName() + "  ||             Quantity: " +fullInventory.get(i).getQuantity()+"\n");
    	}	

    }

    @FXML
    void inventoryCountClicked (ActionEvent event) throws IOException {
    	//String currCount ="";
    	//displayArea.setText(getInvCountOf("BOLT"));
    	Main m = new Main();
    	m.changeScene("InventoryCount.fxml");

    }

    @FXML
    void jobsClicked(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("Jobs.fxml");


    }

    @FXML
    public void userlogout(ActionEvent event) throws IOException{
    	Main m = new Main();
    	m.changeScene("Sample.fxml");

    }
    

    @FXML
    void authorsClicked(ActionEvent event) throws IOException {
    	String name = "";
    	displayArea.setText(name +=" Atif Ali    Email: aali309@myseneca.ca \n Sahil Patel   Email: spatel392@myseneca.ca\n  Aditya Rahman   Email: arahman27@myseneca.ca\n");
    }

    @FXML
    void carsClicked(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("Cars.fxml");

    }

    @FXML
    void clearClicked(ActionEvent event) {
    	displayArea.setText("");
    }

}