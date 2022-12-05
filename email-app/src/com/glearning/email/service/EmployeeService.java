package com.glearning.email.service;

import com.glearning.email.model.Employee;

public class EmployeeService {
	
	private final CredentialService credentialService;
	
	public EmployeeService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}
	
	public String generateEmailAddress(String firstName, String lastName, String dept) {
		return this.credentialService.generateEmailAddress(firstName, lastName, dept);
	}
	public Employee saveCredentials(int length, Employee employee) {
		String password = this.credentialService.generatepassword(length);
		employee.setPassword(password);
		return employee;
	}
	
	public void printEmployee(Employee employee) {
		this.credentialService.showCredential(employee);
	}

}
