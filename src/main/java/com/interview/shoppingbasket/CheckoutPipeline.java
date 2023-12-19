package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPipeline {

    private List<CheckoutStep> steps = new ArrayList<>();

    public PaymentSummary checkout(Basket basket) {
        CheckoutContext checkoutContext = new CheckoutContext(basket);
        for (CheckoutStep checkoutStep : steps) {
            checkoutStep.execute(checkoutContext);
        }

        return checkoutContext.paymentSummary();
    }

    public void addStep(CheckoutStep checkoutStep) {
        steps.add(checkoutStep);
    }
}
