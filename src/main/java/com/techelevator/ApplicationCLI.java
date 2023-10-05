package com.techelevator;

import com.techelevator.view.UserInterface;

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
		Scanner userInput = new Scanner(System.in);
		ui.showWelcomeMessage();

		while (true) {
			/*
			Display the Starting Menu and get the users choice.
			Remember all uses of System.out and System.in should be in the menu
			
			IF the User Choice is Show Inventory,
				THEN show the candy store items for sale
			ELSE IF the User's Choice is Make Sale,
				THEN go to the make sale menu
			ELSE IF the User's Choice is Quit
				THEN break the loop so the application stops
			*/

			ui.printMainMenu();
			int userChoice = userInput.nextInt();
			userInput.nextLine();

			if (userChoice == SHOW_INVENTORY) {
				// TODO
			}
			else if (userChoice == MAKE_SALE) {

				while(true) {
					ui.printSecondMenu();
					int userSecondMenuChoice = userInput.nextInt();
					userInput.nextLine();

					if (userSecondMenuChoice == TAKE_MONEY) {
						// TODO
					}
					else if (userSecondMenuChoice == SELECT_PRODUCTS) {
						// TODO
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

	/*
	 * This starts the application, but you shouldn't need to change it.  
	 */
	public static void main(String[] args) {
		UserInterface menu = new UserInterface();
		ApplicationCLI cli = new ApplicationCLI(menu);
		cli.run();
	}
}
