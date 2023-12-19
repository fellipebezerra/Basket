package com.interview.shoppingbasket;

import lombok.Data;

@Data
public class BasketItem {
    private String productCode;
    private String name;
    private int quantity;
    private double price;

    public BasketItem(String productCode, String name, int quantity, double price) {
        this.productCode = productCode;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public void setPrice(double finalPrice) {
        this.price = finalPrice;
    }

    public double getPrice() {
        return price;
    }
}
