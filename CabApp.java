package com.vikram.cab;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CabApp {
	/**
	 * This method validates the mobile number has 10 digits and password is above 8 characters.
	 * @param mobileNo
	 * @param passWord
	 * @return boolean
	 */
	public static boolean validate(long mobileNo, String passWord) {
		// if password matches login, or return false.
		if (passWord.length() >= 8 && String.valueOf(mobileNo).length() == 10) {
			return true;
		}
		return false;
	}
	/**
	 * This method checks the credentials are correct or not
	 * @param password
	 * @param mobileNumber
	 * @return boolean
	 */
	public static boolean checkCredentials(String password, long mobileNumber) {
		String definedPassword = "KVilambo@4";
		long definedMobileNumber = 9003716350l;
		if(password.equals(definedPassword) && mobileNumber == definedMobileNumber) {
			return true;
		}
		return false;
	}
	/**
	 * This method displays the cabs available in the company.
	 */
	private static void showCabs() {
		String[] cabType = new String[3]; // creating a string array and storing the value
		cabType[0] = "1. Micro (Rs.10/km)";
		cabType[1] = "2. Mini (Rs.15/km)";
		cabType[2] = "3. Prime (Rs.20/km)";
		for (String i : cabType) { // for each statement to display each element in the array.
			System.out.println(i);
		}
	}
	/**
	 * This method will display the price of the peak hours
	 * @param hour
	 * @param price
	 * @return price
	 */
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
	/**
	 * This method calculates age
	 * 
	 * @param dateOfBirth
	 * @return age.
	 */
	public static int calculateAge(String dateOfBirth) {
		LocalDate date_Of_Birth = LocalDate.parse(dateOfBirth);
		LocalDate currentYear = LocalDate.now();
		int year = date_Of_Birth.getYear();
		int age = currentYear.getYear() - year;
		return age;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("================================");
		System.out.println("Welcome to Black Dragoon Cabs :D");
		System.out.println("================================");
		
		long mobileNumber; // storing user mobile no
		String password; // user password
		System.out.println("Enter Mobile Number :");
		mobileNumber = Long.parseLong(input.nextLine());
		System.out.println("Enter Password :");
		password = input.nextLine();
		
		boolean isValidated = validate(mobileNumber, password); // validation result
		boolean isCredentialsMatches = checkCredentials(password, mobileNumber);
		
		if(isValidated && isCredentialsMatches) {
			//code
			System.out.println("Logging In");
			System.out.println("Your Name :");
			String name = input.nextLine();
			
			System.out.println("Your Date of Birth (yyyy-mm-dd)");
			String dateOfBirth = input.next();
			
			System.out.println("Our Services Available for you " + name + "."); // Displaying the services available
			showCabs();
			System.out.println("Pick your choice :)"); // Getting user choice
			int choice = input.nextInt();
			
			System.out.println("Kilometer to travel"); // Getting distance to travel
			int kmToTravel = input.nextInt();
			
			System.out.println("Your Journey Date (yyyy-mm-dd)");
			String journeyDate = input.next();
			
			LocalDate rideDate = LocalDate.parse(journeyDate);
			
			if(checkDate(rideDate) == true) {
				System.out.println("Your Pick Up Time (HH:MM)");
				String pickUpTime = input.next();
				System.out.println("Your Journey Date is : " + rideDate);
				LocalTime rideTime = LocalTime.parse(pickUpTime);
				System.out.println("Your PickUp Time is : " + rideTime);
				int price = calculatePrice(choice, kmToTravel);
				int hour = rideTime.getHour();
				int age = calculateAge(dateOfBirth);
				if(hour >= 05 && hour <=07) {
					System.out.println("5-7 is our peak hours. Additional 1.25% charges may apply.");
					int peakPrice = peakHour(hour, price);
					if (age >= 60) { // Senior Citizenship price deduction 50%.
						int seniorPrice = peakPrice / 2;
						System.out.println("Your Ride Price is :" + " " + "Rs " + seniorPrice);
					}
					System.out.println("Your Ride Price is :" + " " + "Rs " + peakPrice);
				} else {
					if (age >= 60) {
						int seniorPrice = price / 2;
						System.out.println("Your Ride Price is :" + " " + "Rs " + seniorPrice);
				}
					System.out.println("Your Ride Price is :" + " " + "Rs " + price);
					System.out.println("Enjoy the ride");
			}
		}
			else {
			System.out.println("Invalid Login");
		}
	}

}
}
