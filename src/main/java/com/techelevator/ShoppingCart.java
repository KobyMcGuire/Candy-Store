package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import com.techelevator.items.Candy;

public class ShoppingCart {

    private Map<Candy, Integer> shoppingCartMap = new HashMap<>();

    public ShoppingCart() {

    }

    // Methods
    public void addCandyToCart(Candy candy, int quantity) {
        shoppingCartMap.put(candy, Integer.valueOf(quantity));
        System.out.println(shoppingCartMap);
        // TODO
        // loop throuhg map if candy already exists and add to value
    }

    // Getters and Setters


}
