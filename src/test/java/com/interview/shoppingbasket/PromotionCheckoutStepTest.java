package com.interview.shoppingbasket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;

class PromotionCheckoutStepTest {

    @Mock
    private PromotionsService mockPromotionService;

    private PromotionCheckoutStep promotionCheckoutStep;
    private CheckoutContext context;
    private Basket basket;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        promotionCheckoutStep = new PromotionCheckoutStep(mockPromotionService);
        basket = new Basket();
        context = new CheckoutContext(basket);
    }

    @Test
    void testPromotionsApplied() {
        BasketItem item = new BasketItem("product1", "Product 1", 2, 100.0);
        basket.addItem(item);
        List<Promotion> promotions = Arrays.asList(
                new Promotion("product1","product1", Promotion.PromotionType.HALF_PRICE)
        );

        when(mockPromotionService.getPromotionsForProduct("product1")).thenReturn(promotions);

        promotionCheckoutStep.execute(context);

        verify(mockPromotionService).getPromotionsForProduct("product1");
        assertEquals(promotions, context.getItemPromotions(item));
    }
}

