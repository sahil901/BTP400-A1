package jfx;

import java.io.IOException;
import java.util.ArrayList;

import btp400.a1.Job;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Jobs extends btp400.a1.InitialStation{
    @FXML
    private Button back;
    
    @FXML
    private Button jobs;

    @FXML
    private TextArea displayArea;
    
    @FXML
    void jobsClicked(ActionEvent event) {
	String fInv = " " ;
		
		for( int i = 0; i < validJobs.size(); ++i) {
			displayArea.setText(fInv += "Finished job validation for job ID: [" + validJobs.get(i).getJobID()+ "]\n");
			for(int j = 0; j < validJobs.get(i).getTasks().size() ; j++) {
	
			displayArea.setText(fInv += " Successfully validated and added task: " + validJobs.get(i).getTasks().get(j).GetName()+"\n");
		}	
			displayArea.setText(fInv += "**********************************************************************\n");
		}
    }
    

    @FXML
    void backClicked(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("MainPage.fxml");

    }

}



