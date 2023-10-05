package com.techelevator;

import java.math.BigDecimal;

public class CashRegister {

    // INSTANCE VARIABLES
    private BigDecimal balance = new BigDecimal(0.00);
    private final BigDecimal MAX_BALANCE = new BigDecimal(1000);



    // CONSTRUCTOR
    public CashRegister() {

    }


    // UTILITY METHODS
    public void withdraw(BigDecimal amountToWithdraw){

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



    // GETTERS AND SETTERS
    public BigDecimal getBalance() {
        return balance;
    }







}
