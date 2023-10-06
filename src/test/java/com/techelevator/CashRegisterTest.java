package com.techelevator;
import com.techelevator.items.Candy;
import org.junit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;


public class CashRegisterTest {


    private CashRegister cashRegisterTester = new CashRegister();
    private Inventory testInventory = new Inventory();


    @Before
    public void testing_money_to_work_with(){
        cashRegisterTester.deposit(new BigDecimal(50.00));
    }


    @Test
    public void withdraw_test_balance_should_be_45() {
        // ARRANGE
        BigDecimal testWithdraw = new BigDecimal(5.00);

        // ACT
        cashRegisterTester.withdraw(testWithdraw);

        //ASSERT
        Assert.assertEquals(BigDecimal.valueOf(45), cashRegisterTester.getBalance());

    }

    @Test
    public void deposit_test_balance_should_be_55() {
        // ARRANGE
        BigDecimal testDeposit = new BigDecimal(5.00);

        // ACT
        cashRegisterTester.deposit(testDeposit);

        // ASSERT
        Assert.assertEquals(BigDecimal.valueOf(55), cashRegisterTester.getBalance());
    }

    @Test
    public void test_change_return_proper_amount() {
        // ARRANGE
        Map<BigDecimal, Integer> testMap = new HashMap<>();
        testMap.put(BigDecimal.valueOf(20), 2);
        testMap.put(BigDecimal.valueOf(10), 1);


        // ASSERT and ACT
        Assert.assertEquals(testMap, cashRegisterTester.getChange());


    }

    @Test
    public void test_calculate_purchase_amount_should_return_67(){
        // ARRANGE
        Candy testCandy = testInventory.fetchSpecificCandy("C1");
        int testUserQtyChoice = 50;
        BigDecimal testTotalAmount = testCandy.getPrice().multiply(BigDecimal.valueOf(testUserQtyChoice));

        // ACT AND ASSERT
        Assert.assertEquals(testTotalAmount, cashRegisterTester.calculatePurchaseAmount(testUserQtyChoice, testCandy));


    }


}
