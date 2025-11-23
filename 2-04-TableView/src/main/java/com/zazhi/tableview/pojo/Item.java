package com.zazhi.tableview.pojo;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;


public class Item {

    private final String sku;
    private final String descr;
    private final Float price;
    private final Boolean taxable;
    private SimpleObjectProperty<Color> color;

    public Item(String sku, String descr, Float price, Boolean taxable, Color color) {
        this.sku = sku;
        this.descr = descr;
        this.price = price;
        this.taxable = taxable;
        this.color = new SimpleObjectProperty<>(color);
    }

    public String getSku() {
        return sku;
    }

    public String getDescr() {
        return descr;
    }

    public Float getPrice() {
        return price;
    }

    public Boolean getTaxable() {
        return taxable;
    }

    public Color getColor() {
        return color.getValue();
    }

    public SimpleObjectProperty<Color> colorProperty() {
        return color;
    }
}