package com.interview.shoppingbasket;

public class PaymentSummary {
    private double retailPriceTotal;

    public PaymentSummary(double retailPriceTotal) {
        this.retailPriceTotal = retailPriceTotal;
    }

    public double getRetailTotal() {
        return retailPriceTotal;
    }
}
