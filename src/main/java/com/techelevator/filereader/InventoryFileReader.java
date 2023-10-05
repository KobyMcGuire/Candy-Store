package com.techelevator.filereader;

import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.TreeMap;

/*
    This class should contain any and all details of access to the inventory file
 */
public class InventoryFileReader {

    private String inventoryFileName;

    public InventoryFileReader(String inventoryFileName) {
        this.inventoryFileName = inventoryFileName;
    }

    public TreeMap<String, Candy> loadData() {
        TreeMap<String, Candy> candyMap = new TreeMap<>();

        File dataFile = new File(inventoryFileName);

        try (Scanner scanner = new Scanner(dataFile)) {
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String[] splitLine = nextLine.split("\\|");

                // REASSIGN WRAPPED OR NOT VALUE TO Y OR N
                if(splitLine[4].equals("T")){
                    splitLine[4] = "Y";

                }
                else {
                    splitLine[4] = "N";
                }

                // DETERMINE CANDY TYPE AND ASSIGN AS RELEVANT OBJECT
                if (splitLine[0].equals("CH")) {
                    Chocolate tempChoc = new Chocolate(splitLine[1], splitLine[2], new BigDecimal(splitLine[3]), splitLine[4]);
                    candyMap.put(splitLine[1], tempChoc);
                }
                else if (splitLine[0].equals("SR")) {
                    Sours tempSour = new Sours(splitLine[1], splitLine[2], new BigDecimal(splitLine[3]), splitLine[4]);
                    candyMap.put(splitLine[1], tempSour);
                }
                else if (splitLine[0].equals("HC")) {
                    HardCandy tempHardCandy = new HardCandy(splitLine[1], splitLine[2], new BigDecimal(splitLine[3]), splitLine[4]);
                    candyMap.put(splitLine[1], tempHardCandy);
                }
                else if (splitLine[0].equals("LI")) {
                    Licorice tempLicorice = new Licorice(splitLine[1], splitLine[2], new BigDecimal(splitLine[3]), splitLine[4]);
                    candyMap.put(splitLine[1], tempLicorice);
                }
            }


        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return candyMap;
    }
}
