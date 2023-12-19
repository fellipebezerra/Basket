package com.interview.shoppingbasket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class SimplePromotionService implements PromotionsService {
    private List<Promotion> promotions;

    public SimplePromotionService() {
        // Initialize with some hardcoded promotions
        promotions = Arrays.asList(
                new Promotion("code1", "Buy One Get One Free", Promotion.PromotionType.TWO_FOR_ONE),
                new Promotion("code2", "50% Off", Promotion.PromotionType.HALF_PRICE),
                new Promotion("code3", "10% Off", Promotion.PromotionType.TEN_PERCENT_OFF)
        );
    }

    @Override
    public List<Promotion> getPromotionsForProduct(String productCode) {
        // Filter and return promotions for the given product code
        return promotions.stream()
                .filter(promotion -> promotion.getProductCode().equals(productCode))
                .collect(Collectors.toList());
    }
}

