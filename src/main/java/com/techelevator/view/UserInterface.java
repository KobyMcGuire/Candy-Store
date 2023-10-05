package com.techelevator.view;

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

	public void printSecondMenu() {
		System.out.println("(1) Take Money");
		System.out.println("(2) Select Products");
		System.out.println("(3) Complete Sale");
		System.out.println("PUT CASH REGISTER BALANCE HERE");
	}

	public void printMessage(String message) {
		System.out.println(message);
	}
}