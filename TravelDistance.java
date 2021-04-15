package com.vikram.cab;

import java.util.Scanner;

public class TravelDistance {

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
			System.out.println("Pick your choice :)"); //Getting user choice
			@SuppressWarnings("unused")
			int choice = input.nextInt();
			System.out.println("Kilometer to travel"); //Getting distance to travel
			@SuppressWarnings("unused")
			int kmToTravel = input.nextInt();
		}
		System.out.println("Enjoy the ride");
	}

}
