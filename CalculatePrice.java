package com.vikram.cab;

import java.util.Scanner;

public class CalculatePrice {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Welcome to Black Dragoon Cabs :D");
			String[] cabType = new String[3]; // creating a string array and storing the value
			cabType[0] = "1. Micro (Rs.10/km)";
			cabType[1] = "2. Mini (Rs.15/km)";
			cabType[2] = "3. Prime (Rs.20/km)";
			System.out.println("Our Services Available for you."); // Displaying the services available
			for (String i : cabType) { // for each statement to display each element in the array.
				System.out.println(i);
			}
			System.out.println("Pick your choice :)"); // Getting user choice
			int choice = input.nextInt();
			System.out.println("Kilometer to travel"); // Getting distance to travel
			int kmToTravel = input.nextInt();
			System.out.println("Enjoy the ride");
			int price = calculatePrice(choice, kmToTravel);
			System.out.println("Your Ride Price is : " + "Rs " + price);
		}
	}
	/**
	 * This method calculate price of the ride with the GST 7%
	 * @param choice
	 * @param kmToTravel
	 * @return Price
	 */
	private static int calculatePrice(int choice, int kmToTravel) {
		int price = 0;
		if (choice == 1) //if user choice is 1 we calculate the price by multiplying 10 with kilometer to travel
			price = 10 * kmToTravel;

		if (choice == 2) //if user choice is 2 we calculate the price by multiplying 15 with kilometer to travel
			price = 15 * kmToTravel;

		if (choice == 3) //if user choice is 3 we calculate the price by multiplying 20 with kilometer to travel
			price = 20 * kmToTravel;
		return price+=(price * 7)/100; //calculating overall price with GST 7%.
	}

}
