package com.qa.opencart.dataprovider;

public class Product {
	
	String firstName;
	String lastName;
	String emailId;
	String phoneNumber;
	String Password;
	String confirmPassword;
	public Product(String firstName, String lastName, String emailId, String phoneNumber, String password,
			String confirmPassword) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		Password = password;
		this.confirmPassword = confirmPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "Product [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", Password=" + Password + ", confirmPassword=" + confirmPassword + "]";
	}
	
	
	
	

}
