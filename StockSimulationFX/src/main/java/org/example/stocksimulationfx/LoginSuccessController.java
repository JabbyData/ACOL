package org.example.stocksimulationfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginSuccessController {
    @FXML
    private Text usernameSuccessField;

    public String getUsername() {
        return usernameSuccessField.getText();
    }

    @FXML
    public void setUsername(String username) {
        if (usernameSuccessField == null) {
            usernameSuccessField = new Text(username);
        }
        else{
            usernameSuccessField.setText(username);
        }
    }
}
