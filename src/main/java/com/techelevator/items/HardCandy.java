package com.techelevator.items;

import java.math.BigDecimal;

public class HardCandy extends Candy{

    private String productDescription = "Hard Tack Confectionary";

    public HardCandy(String inventoryId, String name, BigDecimal price, String wrappedOrNot) {
        super(inventoryId, name, price, wrappedOrNot);
    }

    // Utility methods

    @Override
    public String getProductDescription() {
        return productDescription;
    }
}
