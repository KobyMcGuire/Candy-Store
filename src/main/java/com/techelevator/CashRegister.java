package com.techelevator;

import com.techelevator.items.Candy;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<BigDecimal, Integer> getChange(){
        final BigDecimal NICKEL = new BigDecimal(0.05).setScale(2, RoundingMode.FLOOR);
        final BigDecimal DIME = new BigDecimal(0.10).setScale(2, RoundingMode.FLOOR);
        final BigDecimal QUARTER = new BigDecimal(0.25);
        final BigDecimal ONE_DOLLAR = new BigDecimal(1);
        final BigDecimal FIVE_DOLLAR = new BigDecimal(5);
        final BigDecimal TEN_DOLLAR = new BigDecimal(10);
        final BigDecimal TWENTY_DOLLAR = new BigDecimal(20);

        Map<BigDecimal, Integer> changeReturned = new HashMap<>();

        while (balance.compareTo(BigDecimal.valueOf(0)) == 1) {
            BigDecimal desiredBill = new BigDecimal(0);
                if(balance.compareTo(TWENTY_DOLLAR) != -1) {
                    desiredBill = TWENTY_DOLLAR;

                }
                else if (balance.compareTo(TEN_DOLLAR) != -1) {
                    desiredBill = TEN_DOLLAR;

                }
                else if (balance.compareTo(FIVE_DOLLAR) != -1) {
                    desiredBill = FIVE_DOLLAR;

                }
                else if (balance.compareTo(ONE_DOLLAR) != -1) {
                    desiredBill = ONE_DOLLAR;

                }
                else if (balance.compareTo(QUARTER) != -1) {
                    desiredBill = QUARTER;

                }
                else if (balance.compareTo(DIME) != -1) {
                    desiredBill = DIME;

                }
                else if (balance.compareTo(NICKEL) != -1) {
                    desiredBill = NICKEL;

                }
                else if (balance.compareTo(NICKEL) == -1) {
                    break;
                }
                balance = balance.subtract(desiredBill);
                balance.setScale(2, RoundingMode.CEILING);

                if (changeReturned.containsKey(desiredBill)) {
                    int amountOfBills = changeReturned.get(desiredBill);
                    changeReturned.put(desiredBill, (amountOfBills + 1));
                }
                else {
                    changeReturned.put(desiredBill, 1);
                }

            }
        // return change in least amount of bills and change;

        return changeReturned;
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
