package com.techelevator.view;

import com.techelevator.CashRegister;
import com.techelevator.ShoppingCart;
import com.techelevator.items.Candy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * This is the only class that should have any usage of System.out or System.in
 *
 * Usage of System.in or System.out should not appear ANYWHERE else in your code outside of this class.
 *
 * Work to get input from the user or display output to the user should be done in this class, however, it
 * should include no "work" that is the job of the candy store.
 */
public class UserInterface {
	
	private static final Scanner in = new Scanner(System.in);

	public void showWelcomeMessage() {
		System.out.println("**********************************");
		System.out.println("**       Silver Shamrock        **");
		System.out.println("**         Candy Company        **");
		System.out.println("**      (Java Green Edition)    **");
		System.out.println("**********************************");
		System.out.println();
	}

	public void printMainMenu() {
		System.out.println("(1) Show Inventory");
		System.out.println("(2) Make Sale");
		System.out.println("(3) Quit");
	}

	public void printSecondMenu(BigDecimal balance) {
		System.out.println("(1) Take Money");
		System.out.println("(2) Select Products");
		System.out.println("(3) Complete Sale");
		System.out.println("Current customer balance: $" + balance);
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	// METHOD
	public void printInventory(List<Candy> candyList){
		System.out.print(String.format("%-5s", "ID"));
		System.out.print(String.format("%-20s", "NAME"));
		System.out.print(String.format("%-10s", "WRAPPER"));
		System.out.print(String.format("%-5s", "QTY"));
		System.out.print(String.format("%-5s", "PRICE"));
		System.out.println();

		for (Candy tempCandy : candyList) {

			System.out.print(String.format("%-5s", tempCandy.getInventoryId()));
			System.out.print(String.format("%-20s", tempCandy.getName()));
			System.out.print(String.format("%-10s", tempCandy.getWrappedOrNot()));
			if (tempCandy.getQuantity() == 0) {
				System.out.println(String.format("%-5s", "SOLD OUT"));
			}
			else {
				System.out.print(String.format("%-5s", tempCandy.getQuantity()));
			}
			System.out.print(String.format("%-5s", tempCandy.getPrice()));
			System.out.println();

		}
	}

	public void printReceipt(Map<Candy, Integer> shoppingCart, Map<BigDecimal, Integer> change, BigDecimal runningTotal, BigDecimal changeTotal) {
		// QUANTITY CANDY-NAME CANDY-TO-STRING BASE-PRICE TOTAL-PRICE
		for (Map.Entry<Candy, Integer> lineItem : shoppingCart.entrySet()) {
			System.out.print(String.format("%-5s", lineItem.getValue()));
			System.out.print(String.format("%-15s", lineItem.getKey().getName()));
			System.out.print(String.format("%-25s", lineItem.getKey().getProductDescription()));
			System.out.print(String.format("%-10s", "$" + lineItem.getKey().getPrice()));
			System.out.print(String.format("%-10s", "$" + lineItem.getKey().getPrice().multiply(BigDecimal.valueOf(lineItem.getValue()))));
			System.out.println();
		}

		System.out.print("Total: $" + runningTotal);
		System.out.println();
		System.out.print("Change: $" + changeTotal);
		System.out.println();

		for (Map.Entry<BigDecimal, Integer> lineItem : change.entrySet()) {
			System.out.println("You are getting (" + lineItem.getValue() +") " + lineItem.getKey().toString() + "'s back");
		}

	}




}
