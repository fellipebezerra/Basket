package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private final List<BasketItem> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(String productCode, String productName, int quantity, double price) {
        BasketItem basketItem = new BasketItem(productCode,productName,quantity,price);
        items.add(basketItem);
    }
    public void addItem(BasketItem item) {
        this.items.add(item);
    }
    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems() {
        Map<String, BasketItem> consolidatedItems = new HashMap<>();

        for (BasketItem item : this.items) {
            if (consolidatedItems.containsKey(item.getProductCode())) {
                BasketItem existingItem = consolidatedItems.get(item.getProductCode());
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
            } else {
                consolidatedItems.put(item.getProductCode(), item);
            }
        }
        this.items.clear();
        this.items.addAll(consolidatedItems.values());

    }
}
