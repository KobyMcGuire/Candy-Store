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


}
