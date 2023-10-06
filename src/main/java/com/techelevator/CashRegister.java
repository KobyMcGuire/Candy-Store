package com.techelevator;

import com.techelevator.items.Candy;
import java.math.BigDecimal;
import java.util.List;

public class CashRegister {

    // INSTANCE VARIABLES
    private BigDecimal balance = new BigDecimal(0.00);
    private final BigDecimal MAX_BALANCE = new BigDecimal(1000);



    // CONSTRUCTOR
    public CashRegister() {

    }


    // UTILITY METHODS
    public void withdraw(BigDecimal amountToWithdraw){
        balance = balance.subtract(amountToWithdraw);
    }

    public void deposit(BigDecimal amountToDeposit) {
        balance = balance.add(amountToDeposit);
    }

    public void getChange(){

    }

    public boolean isUnderMax(BigDecimal amountToDeposit){
        if (amountToDeposit.add(balance).compareTo(MAX_BALANCE) == -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public BigDecimal calculatePurchaseAmount(int userQuantityChoice, Candy userCandyChoice) {
        BigDecimal totalPurchaseAmount = new BigDecimal(0);
        // Wrap quantity choice as a Big Decimal
        BigDecimal userQuantityChoiceAsBigDecimal = BigDecimal.valueOf(userQuantityChoice);

        return totalPurchaseAmount = totalPurchaseAmount.add((userCandyChoice.getPrice().multiply(userQuantityChoiceAsBigDecimal)));

    }



    // GETTERS AND SETTERS
    public BigDecimal getBalance() {
        return balance;
    }







}
