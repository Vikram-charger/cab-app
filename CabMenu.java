package com.vikram.cab;

public class CabMenu {

	public static void main(String[] args) {
		System.out.println("Welcome to Black Dragoon Cabs :D");
		String[] cabType = new String[3]; // creating a string array and storing the value
		cabType[0] = "1. Micro (Rs.10/km)";
		cabType[1] = "2. Mini (Rs.15/km)";
		cabType[2] = "3. Prime (Rs.20/km)";
		System.out.println("Our Services Available for you."); // Displaying the services available
		for (String i : cabType) { // for each statement to display each element in the array.
			System.out.println(i);
		}
	}

}
