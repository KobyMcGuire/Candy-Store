package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.Candy;

import java.util.Map;
import java.util.TreeMap;

public class Inventory {

    public Inventory() {
        InventoryFileReader fileReader = new InventoryFileReader("inventory.csv");
        TreeMap<String, Candy>  candyMap = fileReader.loadData();

        for (Map.Entry<String, Candy> row : candyMap.entrySet()) {
            System.out.println(row.getKey() + " " +  row.getValue().getProductDescription());
        }
    }
}
