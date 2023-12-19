package com.interview.shoppingbasket;

import java.util.HashMap;
import java.util.Map;

public class SimplePricingService implements PricingService {
    private final Map<String, Double> prices;

    public SimplePricingService() {
        // Initialize with some hardcoded prices
        prices = new HashMap<>();
        prices.put("product1", 3.99);
        prices.put("product2", 2.00);
        // Add more products and their prices as needed
    }

    @Override
    public double getPrice(String productCode) {
        return prices.getOrDefault(productCode, 0.0);
    }
}
