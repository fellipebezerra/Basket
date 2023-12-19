package com.interview.shoppingbasket;

import java.util.List;

public class PromotionCheckoutStep implements CheckoutStep {
    private final PromotionsService promotionsService;

    public PromotionCheckoutStep(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }

    @Override
    public void execute(CheckoutContext context) {
        Basket basket = context.getBasket();

        // Iterate over each BasketItem in the Basket
        for (BasketItem item : basket.getItems()) {
            // Fetch promotions for the current item's product code
            List<Promotion> promotions = promotionsService.getPromotionsForProduct(item.getProductCode());

            // Apply the logic to store or use these promotions.
            // This could involve adding them to the CheckoutContext or directly modifying the BasketItem.
            // For example, you might want to store a list of applicable promotions in the CheckoutContext:
            context.addPromotionsForItem(item, promotions);
        }
    }
}

