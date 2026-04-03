package com.jlba.oop2javafx;

import com.jlba.oop2javafx.NoFXML.PasswordValidator;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PasswordValidatorFXML extends Application {
    @FXML
    public TextField passwordTextField;
    @FXML
    public Text statusLabel;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PasswordValidator.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setTitle("Password Validator #8");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void validatePassword(KeyEvent e) {
        PasswordValidator.validatePassword(e, passwordTextField, statusLabel);
    }
}
