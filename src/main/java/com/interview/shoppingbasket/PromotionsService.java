package com.interview.shoppingbasket;

import java.util.List;

interface PromotionsService {
    List<Promotion> getPromotions(Basket basket);
}
