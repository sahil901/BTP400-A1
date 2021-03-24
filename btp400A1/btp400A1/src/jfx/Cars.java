package jfx;

import java.io.IOException;
//import java.util.ArrayList;	
import java.util.Scanner;
//import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextField;
	
public class Cars extends btp400.a1.FinalStation{
	

	    @FXML
	    private Button back;

	    @FXML
	    private Button cars;

	    @FXML
	    private TextField displayArea;

	    @FXML
	    void backClicked(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("MainPage.fxml");
	    }

	    @FXML
	    void carsClicked(ActionEvent event) {
	    	String fInv = " " ;
	    	try {
	    		FileInputStream line = new FileInputStream("CarLog.txt");
	    				Scanner sc = new Scanner(line);
	    				while(sc.hasNextLine()) {
	    					//System.out.println("\n");
	    					 System.out.println(sc.nextLine());
	    					//fInv += sc.nextLine();
	    					//displayArea.setText(sc.toString());
	    					//displayArea.setText(sc.nextLine());
	    				}
	    				sc.close();
	    	}
	    	catch(IOException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	}
	    


