package com.jlba.oop2javafx.Components;

import javafx.scene.control.RadioButton;

public class PriceRadio extends RadioButton {
    double discount;
    public PriceRadio(String text, double discount) {
        super(text);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
