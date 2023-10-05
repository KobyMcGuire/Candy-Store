package com.techelevator.items;

import java.math.BigDecimal;

public class Chocolate extends Candy{

    private String productDescription = "Chocolate Confectionary";

    public Chocolate(String inventoryId, String name, BigDecimal price, String wrappedOrNot) {
        super(inventoryId, name, price, wrappedOrNot);
    }

    // Utility methods

    @Override
    public String getProductDescription() {
        return productDescription;
    }

}
