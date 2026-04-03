package com.jlba.oop2javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

// APP #3
public class CharacterRemover extends Application {
    public String str;
    public Label characterLabel;
    public CheckBox vowelCheckbox;
    public CheckBox consonantCheckbox;
    public CheckBox numberCheckbox;

    public CharacterRemover() {
        str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CharacterRemover.class.getResource("CharacterRemover.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Character Remover #3");
        stage.setScene(scene);
        stage.show();
    }

    public void onRestore() {
        str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        characterLabel.setText(str);
    }

    public void onRemove() {
        StringBuilder targ = new StringBuilder("[");;
        if (vowelCheckbox.isSelected()) targ.append("AEIOU");
        if (consonantCheckbox.isSelected()) targ.append("BCDFGHJKLMNPQRSTVWXYZ");
        if (numberCheckbox.isSelected()) targ.append("1234567890");
        targ.append("]");

        String res;
        try {
            res = str.replaceAll(targ.toString(), "");
            str = res;
            characterLabel.setText(str);
        } catch (Exception e) {}
    }
}
