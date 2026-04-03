package com.jlba.oop2javafx.NoFXML;

import com.jlba.oop2javafx.Components.FoodSelection;
import com.jlba.oop2javafx.Components.PriceRadio;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

// APP #4
public class FoodOrderingSystem extends Application {
    List<FoodSelection> availableFoods;
    private ToggleGroup discountGroup;

    public FoodOrderingSystem() {
        availableFoods = new ArrayList<>();
    }

    @Override
    public void start(Stage stage) throws Exception {

        VBox root = new VBox();
        Scene scene = new Scene(root);
        stage.setTitle("Food Ordering System #4");

        // Root Layout
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setMinWidth(500);
        root.setPadding(new Insets(24));

        HBox hbox = new HBox();
        hbox.setSpacing(24);
        hbox.setAlignment(Pos.CENTER);

        Button btnOrder = new Button("Order");

        root.getChildren().addAll(hbox, btnOrder);

        // Food and Discount Layout
        VBox foodVbox = new VBox();
        foodVbox.setSpacing(4);
        foodVbox.setAlignment(Pos.TOP_CENTER);

        VBox discountVbox = new VBox();
        discountVbox.setSpacing(4);
        discountVbox.setAlignment(Pos.TOP_CENTER);

        hbox.getChildren().addAll(foodVbox, discountVbox);
        HBox.setHgrow(foodVbox, Priority.ALWAYS);


        // Food Section
        Label foodsTitle = new Label("Foods");

        availableFoods.add(new FoodSelection("Pizza", 100));
        availableFoods.add(new FoodSelection("Burger", 80));
        availableFoods.add(new FoodSelection("Fries", 65));
        availableFoods.add(new FoodSelection("Soft Drinks", 55));
        availableFoods.add(new FoodSelection("Tea", 50));
        availableFoods.add(new FoodSelection("Sundae", 40));

        foodVbox.getChildren().addAll(foodsTitle);
        foodVbox.getChildren().addAll(availableFoods);

        // Discount Section
        Label discountTitle = new Label("Discounts");

        discountGroup = new ToggleGroup();

        RadioButton rbNone = new PriceRadio("None", 0);
        RadioButton rb5 = new PriceRadio("5% Off", 0.05);
        RadioButton rb10 = new PriceRadio("10% Off", 0.1);
        RadioButton rb15 = new PriceRadio("15% Off", 0.15);

        rbNone.setToggleGroup(discountGroup);
        rb5.setToggleGroup(discountGroup);
        rb10.setToggleGroup(discountGroup);
        rb15.setToggleGroup(discountGroup);

        discountVbox.getChildren().addAll(discountTitle, rbNone, rb5, rb10, rb15);

        btnOrder.setOnMouseClicked(e -> {onOrder(e, availableFoods, discountGroup);});

        stage.setScene(scene);
        stage.show();
    }

    public static void onOrder(MouseEvent e, List<FoodSelection> availableFoods, ToggleGroup discountGroup) {
        if (e.getButton() == MouseButton.PRIMARY) {
            double total = 0;
            for (FoodSelection food : availableFoods) {
                if (food.isSelected()) {
                    total += food.getPrice();
                }
            }

            if (discountGroup.getSelectedToggle() instanceof PriceRadio d) {
                total -= total*d.getDiscount();
            }

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Order Confirmed");
            alert.setContentText(String.format("Total price is Php %.2f", total));
            alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
            alert.getDialogPane().setGraphic(null);

            alert.showAndWait();
            e.consume();
        }
    }
}
