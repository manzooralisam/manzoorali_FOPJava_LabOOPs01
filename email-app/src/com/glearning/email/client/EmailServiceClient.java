package com.glearning.email.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.glearning.email.model.Employee;
import com.glearning.email.service.CredentialService;
import com.glearning.email.service.EmployeeService;

public class EmailServiceClient {

	private CredentialService  credentialService = new CredentialService();
	private  static EmployeeService employeeService = new EmployeeService(credentialService);
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter first name");
		String firstName = scanner.next();
		
		System.out.println("Please enter last name");
		String lastName = scanner.next();
		
		System.out.println("please enter the date of birth in dd/mm/yy format");
		String strDOB = scanner.next();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/mm/yy");
		LocalDate dob = LocalDate.parse(strDOB, pattern);
		
		Employee newHire = new Employee(firstName, lastName, dob);
		
		System.out.println("Enter your department");
		String dept = scanner.next();
		newHire.setDepartment(dept);
		employeeService.generateEmailAddress(firstName, lastName, dept);
		
		System.out.println("Enter your options From the Following:: ");
		System.out.println("1 ---> Generate password ");
		System.out.println("2 ---> Show details");
		
		int option = scanner.nextInt();
		
		switch(option) {
		case 1:
			employeeService.saveCredentials(8, newHire);
			break;
			
		case 2:
			EmployeeService.show(newHire);
			break;
		}
	}
}
