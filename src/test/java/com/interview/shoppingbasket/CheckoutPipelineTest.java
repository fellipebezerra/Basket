package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

public class CheckoutPipelineTest {

    CheckoutPipeline checkoutPipeline;

    @Mock
    Basket basket;

    @Mock
    CheckoutStep checkoutStep1;

    @Mock
    CheckoutStep checkoutStep2;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        checkoutPipeline = new CheckoutPipeline(Arrays.asList(checkoutStep1, checkoutStep2));
    }

    @Test
    void processEmptyBasketWithoutError() {
        CheckoutContext context = new CheckoutContext(new Basket()); // Assuming an empty basket

        assertDoesNotThrow(() -> checkoutPipeline.execute(context));
        // Additional assertions can be made here if there are specific expectations for an empty basket
    }

    @Test
    void executeAllPassedCheckoutSteps() {
        CheckoutContext context = new CheckoutContext(basket);

        checkoutPipeline.execute(context);

        // Verify that each step is executed
        verify(checkoutStep1, times(1)).execute(context);
        verify(checkoutStep2, times(1)).execute(context);
    }

}
