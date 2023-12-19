package com.interview.shoppingbasket;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CheckoutContext {
    private Basket basket;
    private double retailPriceTotal = 0.0;
    // Assuming you have a Map to store promotions for each BasketItem
    private Map<BasketItem, List<Promotion>> itemPromotions;
    public void setRetailPriceTotal(double retailPriceTotal) {
        this.retailPriceTotal = retailPriceTotal;
    }

    public CheckoutContext(Basket basket) {
        this.basket = basket;
        this.itemPromotions = new HashMap<>();
    }

    public PaymentSummary paymentSummary() {
        return new PaymentSummary(retailPriceTotal);
    }


    public Basket getBasket() {
        return basket;
    }

    public void addPromotionsForItem(BasketItem item, List<Promotion> promotions) {
        itemPromotions.put(item, promotions);
    }

    public List<Promotion> getItemPromotions(BasketItem item) {
        return itemPromotions.getOrDefault(item, Collections.emptyList());
    }
}
