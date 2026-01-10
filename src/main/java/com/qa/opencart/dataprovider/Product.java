package com.qa.opencart.dataprovider;

public class Product {
	
	private String firstName;
	private String lastname;
	private String email;
	private String phoneNumber;
	private String password;
	private String confirmPassword;
	public Product(String firstName, String lastname, String email, String phoneNumber, String password,
			String confirmPassword) {
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "Product [firstName=" + firstName + ", lastname=" + lastname + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	
}
