package com.techelevator.items;

import java.math.BigDecimal;

public class Sours extends Candy{

    private String productDescription = "Sour Flavored Candies";

    public Sours(String inventoryId, String name, BigDecimal price, String wrappedOrNot) {
        super(inventoryId, name, price, wrappedOrNot);
    }

    // Utility methods

    @Override
    public String getProductDescription() {
        return productDescription;
    }
}
