package com.vikram.cab;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class PeakHourPrice {

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
			System.out.println("Your Journey Date (yyyy-mm-dd)");
			String journeyDate = input.next();
			LocalDate rideDate = LocalDate.parse(journeyDate);
			if (checkDate(rideDate) == true) { // Date checking
				System.out.println("Your Pick Up Time (HH:MM)");
				String pickUpTime = input.next();
				System.out.println("Your Journey Date is : " + rideDate);
				LocalTime rideTime = LocalTime.parse(pickUpTime);
				System.out.println("Your PickUp Time is : " + rideTime);
				int price = calculatePrice(choice, kmToTravel);
				int hour = rideTime.getHour();
				if (hour >= 05 && hour <= 7) { // checks the time for peak hours
					System.out.println("5-7 is our peak hours. Additional 1.25% charges may apply.");
					int peakPrice = peakHour(hour, price);
					System.out.println("Your Ride Price is : " + "Rs " + peakPrice);
				} else {
					System.out.println("Your Ride Price is : " + "Rs " + price);
					System.out.println("Enjoy the ride");
				}
			} else
				System.err.println("Enter Valid Date");
		}
	}

	private static int peakHour(int hour, int price) {
		if (hour >= 05 && hour <= 07) {
			price += price * 0.0125;
		}
		return price;
	}

	/**
	 * This method calculate price of the ride with the GST 7%
	 * 
	 * @param choice
	 * @param kmToTravel
	 * @return Price
	 */
	private static int calculatePrice(int choice, int kmToTravel) {
		int price = 0;
		if (choice == 1) // if user choice is 1 we calculate the price by multiplying 10 with kilometer
							// to travel
			price = 10 * kmToTravel;

		if (choice == 2) // if user choice is 2 we calculate the price by multiplying 15 with kilometer
							// to travel
			price = 15 * kmToTravel;

		if (choice == 3) // if user choice is 3 we calculate the price by multiplying 20 with kilometer
							// to travel
			price = 20 * kmToTravel;
		return price += (price * 7) / 100; // calculating overall price with GST 7%.
	}

	/**
	 * This method checks whether the user gives current date or after date
	 * 
	 * @param rideDate
	 * @return true if the user gives date correctly.
	 */
	private static boolean checkDate(LocalDate rideDate) {
		LocalDate currentDate = LocalDate.now();
		if (rideDate.isAfter(currentDate) || rideDate.equals(currentDate))
			return true;
		return false;
	}

//	/**
//	 * This method checks whether the user gives current time or after time
//	 * 
//	 * @param rideTime
//	 * @return true if the user gives time correctly.
//	 */
//	private static boolean checkTime(LocalTime rideTime) {
//		LocalTime currentTime = LocalTime.now();
//		if (rideTime.isAfter(currentTime) || rideTime.equals(currentTime))
//			return true;
//		return false;
//	}
}
