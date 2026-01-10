package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataprovider.Product;

public class RegistrationTest extends BaseTest{
	
	@BeforeClass
	public void doclickRegistration()
	{
		registration=login.navigateRegisterPage();
	}
	
	
	/*
	 * @DataProvider public Object[][] registrationTestData() { return new
	 * Object[][] { {
	 * "Prem","Trhi123","PrAB3643@gmail.com","6787569877","AbETW@123","AbETW@123"},
	 * {
	 * "tripathi","prem123","Pr123@gmail.com","6787569977","prEdfW@123","prEdfW@123"
	 * }, { "tr567athi","pr67m123","Pr1234567@gmail.com","6780569977","prEdjW@123",
	 * "prEdjW@123"} };
	 * 
	 * }
	 */
	
    @DataProvider
	public Object[][] registrationTestData()
	{
		
		return new Object[][] {
			
			{new Product("abc123","bcd456","abcbcd@gmail.com","7651841671","abc@1234","abc@1234")},
			{new Product("abc567","bcd759","efg@gmail.com","7651841673","abc@1234","abc@1234")},
			{new Product("abc199","bcd999","hij@gmail.com","7651841676","abc@1234","abc@1234")}
			
			
		};
		
		
	}
	
	
	
	
	@Test(dataProvider="registrationTestData")
	public void testRegistrationFunctionality(Product prod)
	{
		String mess=registration.doRegistration(prod.getFirstName(),prod.getLastname(),prod.getEmail(),prod.getPhoneNumber(),prod.getPassword(),prod.getConfirmPassword());
		Assert.assertEquals(mess, "Your Account Has Been Created!");
	}

}
