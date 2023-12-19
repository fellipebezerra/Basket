package com.interview.shoppingbasket;

import java.util.List;

public class RetailPriceCheckoutStep implements CheckoutStep {

    @Override
    public void execute(CheckoutContext context) {
        Basket basket = context.getBasket();

        for (BasketItem item : basket.getItems()) {
            List<Promotion> promotions = context.getItemPromotions(item);

            double originalPrice = item.getPrice(); // Assuming getPrice returns the price for a single unit
            double finalPrice = originalPrice * item.getQuantity();

            for (Promotion promotion : promotions) {
                switch (promotion.getType()) {
                    case TWO_FOR_ONE:
                        finalPrice = calculateTwoForOnePrice(item, originalPrice);
                        break;
                    case HALF_PRICE:
                        finalPrice *= 0.5; // 50% off
                        break;
                    case TEN_PERCENT_OFF:
                        finalPrice *= 0.9; // 10% off
                        break;
                }
            }

            // Update the item price or store the final price in the context
            item.setPrice(finalPrice);
            // Alternatively, you can store the final price in the CheckoutContext if needed
            // context.setFinalPriceForItem(item, finalPrice);
        }

        // Additional logic to update the total price of the basket
        updateTotalBasketPrice(context);
    }

    private double calculateTwoForOnePrice(BasketItem item, double originalPrice) {
        // Calculate price based on "2-for-1" promotion
        int pairs = item.getQuantity() / 2;
        int remaining = item.getQuantity() % 2;
        return (pairs + remaining) * originalPrice;
    }

    private void updateTotalBasketPrice(CheckoutContext context) {
        Basket basket = context.getBasket();
        double total = basket.getItems().stream()
                .mapToDouble(BasketItem::getPrice)
                .sum();
        context.setRetailPriceTotal(total); // Assuming there is a method to set total price in CheckoutContext
    }
}

