package com.jlba.oop2javafx;

import com.jlba.oop2javafx.Components.FoodSelection;
import com.jlba.oop2javafx.Components.PriceRadio;
import com.jlba.oop2javafx.NoFXML.FoodOrderingSystem;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FoodOrderingSystemFXML extends Application {
    private List<FoodSelection> availableFoods;

    @FXML public VBox foodsMenu;
    @FXML public VBox discountMenu;
    private ToggleGroup discountGroup;

    public FoodOrderingSystemFXML() {
        this.availableFoods = new ArrayList<>();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("FoodOrderingSystem.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setTitle("Food Ordering System");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void initialize() throws Exception {
        availableFoods.add(new FoodSelection("Pizza", 100));
        availableFoods.add(new FoodSelection("Burger", 80));
        availableFoods.add(new FoodSelection("Fries", 65));
        availableFoods.add(new FoodSelection("Soft Drinks", 55));
        availableFoods.add(new FoodSelection("Tea", 50));
        availableFoods.add(new FoodSelection("Sundae", 40));

        discountGroup = new ToggleGroup();

        RadioButton rbNone = new PriceRadio("None", 0);
        RadioButton rb5 = new PriceRadio("5% Off", 0.05);
        RadioButton rb10 = new PriceRadio("10% Off", 0.1);
        RadioButton rb15 = new PriceRadio("15% Off", 0.15);

        rbNone.setToggleGroup(discountGroup);
        rb5.setToggleGroup(discountGroup);
        rb10.setToggleGroup(discountGroup);
        rb15.setToggleGroup(discountGroup);

        foodsMenu.getChildren().addAll(availableFoods);
        discountMenu.getChildren().addAll(rbNone, rb5, rb10, rb15);
    }

    public void onOrder(MouseEvent e)
    {
        FoodOrderingSystem.onOrder(e, availableFoods, discountGroup);
    }
}
