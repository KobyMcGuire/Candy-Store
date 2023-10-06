package com.techelevator;
import com.techelevator.items.Candy;
import com.techelevator.items.Chocolate;
import org.junit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartTest {

    private ShoppingCart shoppingCartTester = new ShoppingCart();

    @Test
    public void candy_properly_adds_to_cart(){

        // ARRANGE
        Candy testCandy = new Chocolate("C1", "Snuerk", BigDecimal.valueOf(5.00), "Y");

        // ACT
        shoppingCartTester.addCandyToCart(testCandy, 2);

        // ASSERT
        Assert.assertEquals(1, shoppingCartTester.getCopyOfMap().size());

    }

    @Test
    public void candy_properly_adds_to_cart_if_candy_already_exists(){

        // ARRANGE
        Candy testCandy = new Chocolate("C1", "Snuerk", BigDecimal.valueOf(5.00), "Y");

        // ACT
        shoppingCartTester.addCandyToCart(testCandy, 2);
        shoppingCartTester.addCandyToCart(testCandy, 1);
        int testValue = shoppingCartTester.getCopyOfMap().get(testCandy);

        // ASSERT
        Assert.assertEquals(3, testValue);

    }

    @Test
    public void shopping_cart_properly_calculates_running_total(){

        // ARRANGE
        Candy testCandy = new Chocolate("C1", "Snuerk", BigDecimal.valueOf(5), "Y");
        Candy testCandy2 = new Chocolate("C2", "SAFN", BigDecimal.valueOf(4), "Y");
        Candy testCandy3 = new Chocolate("C1", "AAAAA", BigDecimal.valueOf(3), "Y");

        // ACT
        shoppingCartTester.addCandyToCart(testCandy, 1);
        shoppingCartTester.addCandyToCart(testCandy2, 2);
        shoppingCartTester.addCandyToCart(testCandy3, 3);

        BigDecimal testOutput = shoppingCartTester.getRunningTotal();
        BigDecimal testValue = new BigDecimal(22);

        // ASSERT
        Assert.assertEquals(testValue, testOutput);

    }








}
