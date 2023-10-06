package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.Candy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {

    private TreeMap<String, Candy> candyMap;

    public Inventory() {
        InventoryFileReader fileReader = new InventoryFileReader("inventory.csv");
        candyMap = fileReader.loadData();


    }

    public List<Candy> fetchCandyList() {
        List<Candy> candyList = new ArrayList<>();
        for (Map.Entry<String, Candy> row : candyMap.entrySet()) {
            candyList.add(row.getValue());
        }
        return candyList;
    }

    public boolean doesIdExist(String userChoice) {
        return candyMap.containsKey(userChoice);
    }

    public boolean isInStock(String userChoice) {
        int quantity = candyMap.get(userChoice).getQuantity();

        if (quantity <= 0) {
            return false;
        }

        return  true;
    }

    public boolean enoughToPurchase(String userIdChoice ,int userQuantityChoice) {
        int currentStock = candyMap.get(userIdChoice).getQuantity();

        if (currentStock - userQuantityChoice < 0) {
            return false;
        }

        return true;
    }

    public Candy fetchSpecificCandy(String userIdChoice) {
        return candyMap.get(userIdChoice);
    }

    public void updateStock(Candy userCandyChoice, int amountPurchased){
        userCandyChoice.setQuantity(userCandyChoice.getQuantity() - amountPurchased);

    }


}
