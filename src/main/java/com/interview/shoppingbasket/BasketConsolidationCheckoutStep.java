package com.interview.shoppingbasket;

public class BasketConsolidationCheckoutStep implements CheckoutStep {

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        basket.consolidateItems();
    }

}
