package com.interview.shoppingbasket;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CheckoutContext {
    private final Basket basket;
    private double retailPriceTotal = 0.0;

    private final Map<BasketItem, List<Promotion>> itemPromotions;
    public void setRetailPriceTotal(double retailPriceTotal) {
        this.retailPriceTotal = retailPriceTotal;
    }

    public CheckoutContext(Basket basket) {
        this.basket = basket;
        this.itemPromotions = new HashMap<>();
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
