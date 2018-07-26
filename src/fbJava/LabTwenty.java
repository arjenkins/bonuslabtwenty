package fbJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LabTwenty {

	public static void main(String[] args) {

		//this progam allows the user to see a list of dispayed items, and select each item they want to purchase.
		//Every item purchased will be dispayed on the screen and the console will show the average price,
		//lowest price, and highest price paid for their items. 
		//created by Anesha Robinson-Jenkins
		
		
		// key is item as a string & value is price as a double
		HashMap<String, Double> inventory = new HashMap<String, Double>();
		ArrayList<String> shoppingCart = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		String cont;
		// to have them enter item, there has to be methods created that have a scanner, inventory, and prompt
		// the method will return a string that adds to the shopping cart
		System.out.println("Welcome to Annie's Market!");
		System.out.println("");
		
		
		inventory = fillInventory(inventory); // this fills the inventory
		
		displayInventory(inventory); // used a for loop in the display inventory method

		do {
			// prompts user to select an item to add to cart
			System.out.println("");
			String prompt = "What would you like to order? ";
			String newItem = enterItem(scan, inventory, prompt); // new item is the items they will be adding
			shoppingCart.add(newItem); // adds the item to shoppingCart
			
			System.out.println("Add another item? (y/n)");  //prompts user to see if they want to continue
			cont = scan.nextLine();						   // if yes, creates a loop to ask user to enter another item
			cont = cont.toLowerCase();					  //if no, exists loop and displays what's in user cart

		} while (cont.startsWith("y")); 
		// if no, display the average price, and the highest and lowest cost items in cart
		
		System.out.println("This is your shopping cart: ");
		System.out.println(shoppingCart);

		//this displays average price of all item
		averagePrice(shoppingCart, inventory);

		//this displays highest priced item
		highestPrice(shoppingCart, inventory);

		//this displays lowest priced item
		lowestPrice(shoppingCart, inventory);
	}

	private static void lowestPrice(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double lowestPrice = 500.00; 
		// this method gets the lowest price of each fruit
		for (String fruit : shoppingCart) {

			if (lowestPrice > inventory.get(fruit)) {
				lowestPrice = inventory.get(fruit);
				System.out.println("The item(s) ordered that cost the least were: " + fruit);
			}
		}
	}

	private static void highestPrice(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double highestPrice = 0.0;
		// this method gets the highest price of each fruit
		for (String fruit : shoppingCart) {

			if (highestPrice < inventory.get(fruit)) {
				highestPrice = inventory.get(fruit);
				System.out.println("The item(s) ordered that cost the most were: " + fruit);
			}

		}

	}

	private static void averagePrice(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double sum = 0;// the total price of all items added together
		int count = 0; // the number of individual items
		for (String fruit : shoppingCart) { // this goes thru each fruit in the cart to get the average price

			sum += inventory.get(fruit); 
			count++;
		}

		System.out.println("This is the average price of all items ordered: " + sum / count);
	}

	private static String enterItem(Scanner scan, HashMap<String, Double> inventory, String prompt) {
		String userInput;
		// if userInput is our inventory, then return userInput
		// else, repeat the method

		System.out.println(prompt);
		userInput = scan.nextLine();

		if (inventory.containsKey(userInput) == true) { //this looks to see if user input = a word from inventory
			System.out.println("Success! " + userInput + " has been added to your cart!");

					} else { 		// else, repeat the method

			System.out.println("Sorry, " + userInput + " is no longer available.");
			enterItem(scan, inventory, prompt);
		}

		return userInput;
	}

	private static void displayInventory(HashMap<String, Double> inventory) {
		//spacing format for items and price
		String format2 = "%-12s : %s";
		System.out.printf(format2, "Item", "Price");
		System.out.println();
		System.out.println("=======================");

		//this will loop through the inventory
		for (String fruit : inventory.keySet()) {
			System.out.printf(format2, fruit, inventory.get(fruit) + "\n"); //added a new line to make it print in a row
			
		}

	}

	//this passes the data from hashmap into fills inventory
	private static HashMap<String, Double> fillInventory(HashMap<String, Double> inventory) {
		inventory.put("apples", 0.99);
		inventory.put("bananas", 0.52);
		inventory.put("squash", 0.99);
		inventory.put("figs", 2.19);
		inventory.put("dragonfruit", 1.59);
		inventory.put("mangos", 1.59);
		inventory.put("honeydew", 1.99);
		inventory.put("papaya", 2.99);

		return inventory;

	}

}
