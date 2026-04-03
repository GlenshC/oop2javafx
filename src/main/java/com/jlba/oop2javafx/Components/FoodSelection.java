package com.jlba.oop2javafx.Components;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class FoodSelection extends HBox {
    private final int price;
    private final CheckBox checkBox;

    public FoodSelection(String title, int price) {
        super();
        this.price = price;

        checkBox = new CheckBox();
        checkBox.addEventFilter(MouseEvent.MOUSE_PRESSED, Event::consume);
        Label name = new Label(title);
        Label priceTitle = new Label(String.format("Php %d", price));

        this.setSpacing(4);
        this.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(checkBox,name,priceTitle);

        name.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(name, Priority.ALWAYS);

        setPickOnBounds(true);

        setMaxWidth(Double.MAX_VALUE);
        addEventFilter(MouseEvent.MOUSE_CLICKED, this::onMouseClicked);
    }

    private void onMouseClicked(MouseEvent e)
    {
        if (e.getButton() == MouseButton.PRIMARY) {
            checkBox.fire();
            e.consume();
        }
    }

    public boolean isSelected() {
        return checkBox.isSelected();
    }

    public int getPrice() {
        return price;
    }
}
