package com.techelevator;

import java.math.BigDecimal;
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

        // TODO
        // loop throuhg map if candy already exists and add to value
    }

    public void printCart() {
        for(Map.Entry<Candy, Integer> lineItem : shoppingCartMap.entrySet()) {
            System.out.println(lineItem.getKey() + " " + lineItem.getValue());
        }
    }

    public Map<Candy, Integer> getCopyOfMap() {
        Map<Candy, Integer> copyOfMap = new HashMap<>();

        for (Map.Entry<Candy, Integer> lineItem : shoppingCartMap.entrySet()) {
            copyOfMap.put(lineItem.getKey(), lineItem.getValue());
        }

        return copyOfMap;
    }

    public BigDecimal getRunningTotal() {
        BigDecimal total = new BigDecimal(0);

        for (Map.Entry<Candy, Integer> lineItem : shoppingCartMap.entrySet()) {
            total = total.add(lineItem.getKey().getPrice().multiply(BigDecimal.valueOf(lineItem.getValue())));
        }

        return total;
    }

    public void clearCart() {
        shoppingCartMap.clear();
    }

    // Getters and Setters


}
