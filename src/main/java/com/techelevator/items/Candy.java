package com.techelevator.items;

import java.math.BigDecimal;

/*
    This represents a single candy store item in the system

    This is an abstract class that should be used as a superclass for the more specific items.
 */
public abstract class Candy {

    private String inventoryId;
    private String name;
    private int quantity = 100;
    private BigDecimal price;
    private String wrappedOrNot;

    public Candy(String inventoryId, String name, BigDecimal price, String wrappedOrNot) {
        this.inventoryId = inventoryId;
        this.name = name;
        this.price = price;
        this.wrappedOrNot = wrappedOrNot;
    }



    // Getters and Setters

    public abstract String getProductDescription();

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getWrappedOrNot() {
        return wrappedOrNot;
    }

}
