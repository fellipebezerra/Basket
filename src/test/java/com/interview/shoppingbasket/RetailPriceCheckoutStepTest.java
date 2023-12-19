package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class RetailPriceCheckoutStepTest {

    PricingService pricingService;
    CheckoutContext checkoutContext;
    Basket basket;

    private RetailPriceCheckoutStep retailPriceCheckoutStep;
    private CheckoutContext context;

    @BeforeEach
    void setup() {
        pricingService = Mockito.mock(PricingService.class);
        checkoutContext = Mockito.mock(CheckoutContext.class);
        basket = new Basket();
        context = new CheckoutContext(basket);
        retailPriceCheckoutStep = new RetailPriceCheckoutStep();

        when(checkoutContext.getBasket()).thenReturn(basket);
    }

    @Test
    void setPriceZeroForEmptyBasket() {

        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep();

        retailPriceCheckoutStep.execute(checkoutContext);

        Mockito.verify(checkoutContext).setRetailPriceTotal(0.0);
    }

    @Test
    void setPriceOfProductToBasketItem() {

        basket.add("product1", "myproduct1", 10, 3.99);
        basket.add("product2", "myproduct2", 10, 2.0);

        when(pricingService.getPrice("product1")).thenReturn(3.99);
        when(pricingService.getPrice("product2")).thenReturn(2.0);
        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep();

        retailPriceCheckoutStep.execute(checkoutContext);
        Mockito.verify(checkoutContext).setRetailPriceTotal(3.99*10+2*10);

    }

    @Test
    void testFinalPriceCalculation() {
        BasketItem item = new BasketItem("product1", "Product 1", 2, 50.0);
        basket.addItem(item);
        List<Promotion> promotions = Arrays.asList(
                new Promotion("product1","product1", Promotion.PromotionType.HALF_PRICE)
        );
        context.addPromotionsForItem(item, promotions);

        retailPriceCheckoutStep.execute(context);

        double expectedPrice = 50.0 * 2 * 0.5; // Half price for 2 items
        assertEquals(expectedPrice, item.getPrice());
    }


}
