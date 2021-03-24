package jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login{

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button button;

    @FXML
    private Label wronglogin;

    @FXML
    public void userlogin(ActionEvent event) throws Exception {
    	checkLogin();
    }
    
    private void checkLogin() throws Exception{
    	Main m = new Main();
    	if(username.getText().toString().equals("abc") && password.getText().toString().equals("123")) {
    		wronglogin.setText("Success");
    		m.changeScene("mainpage.fxml");
    	}
    	else if(username.getText().isEmpty() || password.getText().isEmpty()) {
    		wronglogin.setText("Please enter login details");
    	}
    	else {
    		wronglogin.setText("Wrong Username/Password");
    	}
    }

}
