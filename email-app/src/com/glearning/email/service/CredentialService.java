package com.glearning.email.service;

import java.util.Random;

import com.glearning.email.model.Employee;

public class CredentialService {

	private static final String DOMAIN_NAME = "abc.com";
	private static final String DELIMITTER = "";
	private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "1234567890";
	private static final String SPECIAL_CHARS = "!@#$%^&*()_+";

	
	public String generatepassword(int length) {
		
		String value = UPPER_CASE + LOWER_CASE + NUMBERS + SPECIAL_CHARS;
		Random random = new Random();
		
		char[] password = new char[length];
		
		for ( i =0; i < length; i ++) {
			password [i] = value.charAt(random.nextInt(value.length))
		}
		return password.toString();
		
	}
	
	public String generateEmailAddress(String firstName, String lastName, String department) {
		String emailAddress = firstName+DELIMITTER+lastName+"@"+department+DOMAIN_NAME;
		return emailAddress;
	}
	
	public void showCredential(Employee employee) {
		System.out.println("====== Displaying the details of the employee ====");
		System.out.println("First Name :: "+ employee.getFirstName());
		System.out.println("Last Name :: "+ employee.getLastName());
		System.out.println("Email Address ::"+ employee.getEmailAddress());
		System.out.println("Password ::"+ employee.getPassword());
		System.out.println("Date of Birth ::"+ employee.getDateOfBirth());
		System.out.println("===Display the details of the employee - start ====");
	}
	
}
