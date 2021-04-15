package com.vikram.cab;

public class Login {

	static long mobNo; // Global declaration

	public static void main(String[] args) {
		mobNo = 9003716350L; // storing user mobile no
		String passWord = "HeloBan@8"; // user password
		boolean isValidated = validate(mobNo, passWord); // validation result
		// Login in if the credentials matches
		if (isValidated) { // returns true if validation is success
			System.out.println("Logging In");
		} else {
			System.out.println("Login Failed, Check again");
		}
	}

	/**
	 * This method validate the user credentials.
	 * 
	 * @param mobileNo
	 * @param passWord
	 * @return
	 */
	private static boolean validate(long mobileNo, String passWord) {
		// if password matches login, or return false.
		if (passWord.equals("HeloBan@8")) {
			return true;
		}
		return false;
	}
}
