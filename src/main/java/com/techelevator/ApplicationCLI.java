package com.techelevator;

import com.techelevator.items.Candy;
import com.techelevator.view.UserInterface;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

	// First Menu Options
	private final int SHOW_INVENTORY = 1;
	private final int MAKE_SALE = 2;
	private final int QUIT = 3;

	// Second menu Options
	private final int TAKE_MONEY = 1;
	private final int SELECT_PRODUCTS = 2;
	private final int COMPLETE_SALE = 3;

	Scanner userInput = new Scanner(System.in);



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
			int userChoice = userInput.nextInt();
			userInput.nextLine();

			if (userChoice == SHOW_INVENTORY) {
				// TODO
				showInventory();

			}
			else if (userChoice == MAKE_SALE) {

				while(true) {
					ui.printSecondMenu(cashRegister.getBalance());
					int userSecondMenuChoice = userInput.nextInt();
					userInput.nextLine();

					if (userSecondMenuChoice == TAKE_MONEY) {
						takeMoney();

					}
					else if (userSecondMenuChoice == SELECT_PRODUCTS) {
						// TODO
						String postSelectMessage = selectProducts();
						ui.printMessage(postSelectMessage);
					}
					else if (userSecondMenuChoice == COMPLETE_SALE) {
						// TODO
					}
					else {
						ui.printMessage(invalidInputMessage);
					}

				}
			}
			else if (userChoice == QUIT) {
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
				break;
			}

			else {
				ui.printMessage("Invalid input, please try again");
			}
		}

	}

	public String selectProducts() {
		ui.printInventory(inventory.fetchCandyList());

		ui.printMessage("Please enter the inventory id of the candy you would like to purchase: ");
		String userIdChoice = userInput.nextLine();

		ui.printMessage("Please enter an amount to buy: ");
		int userQuantityChoice = userInput.nextInt();
		userInput.nextLine();

		if (!inventory.doesIdExist(userIdChoice)) {
			return "This product does not exist.";
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

		shoppingCart.addCandyToCart(userCandyChoice, userQuantityChoice);
		cashRegister.withdraw(totalPurchaseAmount);
		return "Candy has been added to your cart";
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
