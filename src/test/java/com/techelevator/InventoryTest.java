package com.techelevator;
import com.techelevator.items.Candy;
import com.techelevator.items.Chocolate;
import org.junit.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class InventoryTest {


    private Inventory inventoryTester = new Inventory();
    private Candy testCandy;


    @Before
    public void run_before_test(){
        testCandy = inventoryTester.fetchSpecificCandy("C1");
    }

    @Test
    public void does_id_exist_test_true() {

        // ASSERT AND ACT
        Assert.assertTrue(inventoryTester.doesIdExist("C1"));


    }

    @Test
    public void does_id_exist_test_false() {
        // ASSERT AND ACT
        Assert.assertFalse(inventoryTester.doesIdExist("AJGNFG"));

    }

    @Test
    public void is_in_stock_test_true() {
        // ACT AND ASSERT
        Assert.assertTrue(inventoryTester.isInStock("C1"));


    }

    @Test
    public void is_in_stock_test_false() {
        // ARRANGE
        inventoryTester.updateStock(testCandy, 100);

        // ACT AND ASSERT
        Assert.assertFalse(inventoryTester.isInStock("C1"));


    }

    @Test
    public void enough_to_purchase_test_true() {
        // ARRANGE
        int userQuantityChoice = 50;
        // ACT AND ASSERT
        Assert.assertTrue(inventoryTester.enoughToPurchase("C1", userQuantityChoice));
    }

    @Test
    public void enough_to_purchase_test_false() {
        // ARRANGE
        int userQuantityChoice = 101;
        // ACT AND ASSERT
        Assert.assertFalse(inventoryTester.enoughToPurchase("C1", userQuantityChoice));
    }


}
