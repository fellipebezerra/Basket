package com.interview.shoppingbasket;

import java.util.List;

public class CheckoutPipeline {

    private final List<CheckoutStep> steps;

    public CheckoutPipeline(List<CheckoutStep> steps) {
        this.steps = steps;
    }

    public void execute(CheckoutContext context) {
        for (CheckoutStep step : steps) {
            step.execute(context);
        }
    }
}
