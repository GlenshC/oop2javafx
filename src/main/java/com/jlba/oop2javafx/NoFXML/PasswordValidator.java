package com.jlba.oop2javafx.NoFXML;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PasswordValidator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setMinWidth(300);
        root.setMaxWidth(Double.MAX_VALUE);
        root.setSpacing(16);
        root.setPadding(new Insets(24));

        TextField passwordTextField = new TextField();
        passwordTextField.setPromptText("Enter Password");

        Text statusLabel = new Text();
        root.getChildren().addAll(passwordTextField,statusLabel);

        passwordTextField.setOnKeyTyped(e -> {
            validatePassword(e, passwordTextField, statusLabel);
        });

        Scene scene = new Scene(root);
        stage.setTitle("Password Validator #8");
        stage.setScene(scene);
        stage.show();
    }

    public static void validatePassword(KeyEvent e, TextField password, Text statusLabel) {
        String pass = password.getText();
        statusLabel.setFill(Color.RED);
        if (pass.length() < 8)
        {
            statusLabel.setText("Password must be 8 characters long");
        }
        else if (!pass.matches(".*\\d.*"))
        {
            statusLabel.setText("Password must contain at least one digit");
        }
        else if (!pass.matches(".*[^a-zA-Z0-9].*"))
        {
            statusLabel.setText("Password must contain at least one special character");
        }
        else
        {
            statusLabel.setText("Password is valid");
            statusLabel.setFill(Color.GREEN);
        }
        e.consume();
    }

}
