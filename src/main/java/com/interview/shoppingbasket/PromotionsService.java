package com.interview.shoppingbasket;

import java.util.List;

interface PromotionsService {
    /**
     * Retrieves a list of promotions applicable to a given product code.
     *
     * @param productCode The product code to find promotions for.
     * @return A list of promotions applicable to the given product code.
     */
    List<Promotion> getPromotionsForProduct(String productCode);
}
