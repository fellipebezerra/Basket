package com.interview.shoppingbasket;

public class Promotion {
    private String productCode;
    private String description;
    private PromotionType type;

    public enum PromotionType {
        TWO_FOR_ONE, // Represents 2 items for the price of 1
        HALF_PRICE, // Represents 50% off retail price
        TEN_PERCENT_OFF // Represents 10% off retail price
    }

    // Constructor
    public Promotion(String productCode, String description, PromotionType type) {
        this.productCode = productCode;
        this.description = description;
        this.type = type;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PromotionType getType() {
        return type;
    }

    public void setType(PromotionType type) {
        this.type = type;
    }
}
