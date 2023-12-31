package com.techelevator;

import com.techelevator.filereader.LogFileWriter;
import com.techelevator.items.Candy;
import com.techelevator.view.UserInterface;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

/*
 * This class should control the workflow of the application, but not do any other work
 * 
 * The menu class should communicate with the user, but do no other work
 * 
 * This class should control the logical workflow of the application, but it should do no other
 * work.  It should communicate with the user (System.in and System.out) using the Menu class and ask
 * the CandyStore class to do any work and pass the results between those 2 classes.
 */
public class ApplicationCLI {

	/*
	 * The menu class is instantiated in the main() method at the bottom of this file.  
	 * It is the only class instantiated in the starter code.  
	 * You will need to instantiate all other classes using the new keyword before you can use them.
	 * 
	 * Remember every class and data structure is a data types and can be passed as arguments to methods or constructors.
	 */
	private UserInterface ui;
	private Inventory inventory = new Inventory();
	private CashRegister cashRegister = new CashRegister();
	private ShoppingCart shoppingCart = new ShoppingCart();
	private LogFileWriter writer = new LogFileWriter();
	private Scanner userInput = new Scanner(System.in);


	// First Menu Options
	private final int SHOW_INVENTORY = 1;
	private final int MAKE_SALE = 2;
	private final int QUIT = 3;

	// Second menu Options
	private final int TAKE_MONEY = 1;
	private final int SELECT_PRODUCTS = 2;
	private final int COMPLETE_SALE = 3;



	public ApplicationCLI(UserInterface menu) {
		this.ui = menu;
	}

	/*
	 * Your application starts here
	 */
	public void run() {
		String invalidInputMessage = "Invalid input, please try again.";
		ui.showWelcomeMessage();

		while (true) {

			ui.printMainMenu();
			// Checking if input is correct
			String userChoice = userInput.nextLine();
			int userChoiceAsInt = 0;
			try {
				userChoiceAsInt = Integer.parseInt(userChoice);
			} catch (Exception e) {
				ui.printMessage("ERROR");
			}

			if (userChoiceAsInt == SHOW_INVENTORY) {
				showInventory();

			}
			else if (userChoiceAsInt == MAKE_SALE) {

				while(true) {
					ui.printSecondMenu(cashRegister.getBalance());
					// Checking if user input is okay
					String userSecondMenuChoice = userInput.nextLine();
					int userSecondChoiceAsInt = 0;
					try{
						userSecondChoiceAsInt = Integer.parseInt(userSecondMenuChoice);
					} catch (Exception e) {
						ui.printMessage("ERROR");
					}

					if (userSecondChoiceAsInt == TAKE_MONEY) {
						takeMoney();
					}
					else if (userSecondChoiceAsInt == SELECT_PRODUCTS) {
						String postSelectMessage = selectProducts();
						ui.printMessage(postSelectMessage);
					}
					else if (userSecondChoiceAsInt == COMPLETE_SALE) {
						makeSale();
						break;
					}
					else {
						ui.printMessage(invalidInputMessage);
					}

				}
			}
			else if (userChoiceAsInt == QUIT) {
				break;
			}
			else {
				ui.printMessage(invalidInputMessage);
			}

		}
	}

	// METHODS
	private void showInventory(){
		List<Candy> candyList = inventory.fetchCandyList();
		ui.printInventory(candyList);
	}

	private void takeMoney(){
		while(true) {
			ui.printMessage("Please deposit an amount 1 - 100 dollars (whole number value only)");
			int amountToTake = 0;
			try{
				amountToTake = userInput.nextInt();
			} catch(InputMismatchException e) {
				ui.printMessage("Expected whole value");

			}
			// PARSE INT AS BIG DECIMAL AND REASSIGN
			BigDecimal deposit = BigDecimal.valueOf(amountToTake);
			userInput.nextLine();

			if (amountToTake >= 1 && amountToTake <= 100 && cashRegister.isUnderMax(deposit)) {
				cashRegister.deposit(deposit);
				writer.writeDeposit(deposit, cashRegister.getBalance());
			}

			else {
				ui.printMessage("Invalid input or max balance ($1000.00) exceeded ");

			}
			break;
		}

	}

	// SELECT PRODUCT METHOD
	public String selectProducts() {
		ui.printInventory(inventory.fetchCandyList());

		ui.printMessage("Please enter the inventory id of the candy you would like to purchase: ");
		String userIdChoice = userInput.nextLine();

		if (!inventory.doesIdExist(userIdChoice)) {
			return "This product does not exist.";
		}

		ui.printMessage("Please enter an amount to buy: ");
		int userQuantityChoice = 0;
		try {
			userQuantityChoice = userInput.nextInt();
		} catch (InputMismatchException e) {
			ui.printMessage("ERROR");
		}
		userInput.nextLine();
		if (userQuantityChoice <= 0) {
			return "Invalid quantity entered. Please enter a whole number.";
		}


		Candy userCandyChoice = inventory.fetchSpecificCandy(userIdChoice);
		BigDecimal totalPurchaseAmount = cashRegister.calculatePurchaseAmount(userQuantityChoice, userCandyChoice);

		if (!inventory.isInStock(userIdChoice)) {
			return "This product is out of stock";
		}

		if (!inventory.enoughToPurchase(userIdChoice, userQuantityChoice)) {
			return "Your chosen amount exceeds our stock.";
		}

		if (totalPurchaseAmount.compareTo(cashRegister.getBalance()) == 1) {
			return "Insufficient funds for purchase";
		}
		// THINGS THAT HAPPEN AFTER CHOICE IS CONFIRMED VALID
		shoppingCart.addCandyToCart(userCandyChoice, userQuantityChoice);
		cashRegister.withdraw(totalPurchaseAmount);
		writer.writeCandyPurchased(userCandyChoice, userQuantityChoice, cashRegister.getBalance());
		inventory.updateStock(userCandyChoice, userQuantityChoice);

		return  userCandyChoice.getName() + " has been added to your cart.";
	}

	// MAKE SALE METHOD
	public void makeSale(){
		// Grab total change before we clear it
		BigDecimal changeTotal = cashRegister.getBalance();

		// method that returns change
		Map<BigDecimal, Integer> changeReturned = cashRegister.getChange();

		// Write to File
		writer.writeChange(changeTotal, cashRegister.getBalance());

		// Print Receipt
		ui.printReceipt(shoppingCart.getCopyOfMap(), changeReturned, shoppingCart.getRunningTotal(), changeTotal);

		// Clearing Cart
		shoppingCart.clearCart();
	}

	/*
	 * This starts the application, but you shouldn't need to change it.  
	 */
	public static void main(String[] args) {
		UserInterface menu = new UserInterface();
		ApplicationCLI cli = new ApplicationCLI(menu);
		cli.run();
	}
}
