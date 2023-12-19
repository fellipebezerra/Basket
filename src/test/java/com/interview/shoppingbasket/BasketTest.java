package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    void emptyBasket() {
        Basket basket = new Basket();
        List<BasketItem> basketSize = basket.getItems();

        assertEquals(basketSize.size(), 0);
    }

    @Test
    void createBasketFullConstructor() {
        Basket basket = new Basket();
        basket.add("productCode", "myProduct", 10);
        List<BasketItem> basketSize = basket.getItems();

        assertEquals(basketSize.size(), 1);
        assertEquals(basketSize.get(0).getProductCode(), "productCode");
        assertEquals(basketSize.get(0).getProductName(), "myProduct");
        assertEquals(basketSize.get(0).getQuantity(), 10);
    }

    @Test
    void createBasketWithMultipleProducts() {
        Basket basket = new Basket();
        basket.add("productCode", "myProduct", 10);
        basket.add("productCode2", "myProduct2", 10);
        basket.add("productCode3", "myProduct3", 10);

        List<BasketItem> basketSize = basket.getItems();

        assertEquals(basketSize.size(),3);
        assertEquals(basketSize.get(0).getProductCode(), "productCode");
        assertEquals(basketSize.get(0).getProductName(), "myProduct");
        assertEquals(basketSize.get(0).getQuantity(), 10);
        assertEquals(basketSize.get(1).getProductCode(), "productCode2");
        assertEquals(basketSize.get(1).getProductName(), "myProduct2");
        assertEquals(basketSize.get(1).getQuantity(), 10);
        assertEquals(basketSize.get(2).getProductCode(), "productCode3");
        assertEquals(basketSize.get(2).getProductName(), "myProduct3");
        assertEquals(basketSize.get(2).getQuantity(), 10);
    }

    @Test
    void consolidateBasketTest() {
        Basket basket = new Basket();

        // Add BasketItems to the Basket. Assume the BasketItem constructor takes productCode, name, and quantity.
        basket.add("productCode1", "Item 1", 2);
        basket.add("productCode2", "Item 2", 1);
        basket.add("productCode1", "Item 1", 3);

        // Call the consolidateItems method
        basket.consolidateItems();

        // Assertions to check the consolidation logic
        assertEquals(2, basket.getItems().size(), "Basket should have 2 items after consolidation");

        // Check if the quantities are consolidated correctly
        BasketItem consolidatedItem = basket.getItems().stream()
                .filter(item -> item.getProductCode().equals("productCode1"))
                .findFirst()
                .orElse(null);

        assertNotNull(consolidatedItem, "Item with productCode 'productCode1' should exist");
        assertEquals(5, consolidatedItem.getQuantity(), "Quantity of 'productCode1' items should be 5 after consolidation");

        // Additional checks can be added as needed
    }
}
