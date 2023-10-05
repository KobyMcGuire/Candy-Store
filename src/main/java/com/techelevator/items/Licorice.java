package com.techelevator.items;

import java.math.BigDecimal;

public class Licorice extends Candy{

    private String productDescription = "Licorice and Jellies";

    public Licorice(String inventoryId, String name, BigDecimal price, String wrappedOrNot) {
        super(inventoryId, name, price, wrappedOrNot);
    }

    // Utility methods

    @Override
    public String getProductDescription() {
        return productDescription;
    }
}
