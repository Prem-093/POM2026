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
	
	/*
	 * @DataProvider public Object[][] registrationTestData() {
	 * 
	 * return new Object[][] {
	 * 
	 * {new Product("abc123","bcd456","abcbcd@gmail.com","7651841671","abc@1234",
	 * "abc@1234")}, {new
	 * Product("abc567","bcd759","efg@gmail.com","7651841673","abc@1234","abc@1234")
	 * }, {new
	 * Product("abc199","bcd999","hij@gmail.com","7651841676","abc@1234","abc@1234")
	 * }
	 * 
	 * 
	 * };
	 * 
	 * 
	 * }
	 */
	
	@DataProvider
	
	public  Object[][] getRegistrationData()
	{
		
		return new Object[][]
				{
			
			{new Product("Prem","Tripathi","Prem1234@gmail.com","7651841672","abc@123","abc@123")},
			{new Product("Pranshi","Tripathi","Prem5674@gmail.com","7651841673","abc@123","abc@123")},
			{new Product("Nidhi","Tripathi","Prem8910@gmail.com","7651841674","abc@123","abc@123")}
			 
			
				};
	}
	
	
	
	@Test(dataProvider="getRegistrationData")
	public void testRegistrationFunctionality(Product prod)
	{
		String mess=registration.doRegistration(prod.getFirstName(),prod.getLastName(),prod.getEmailId(),prod.getPhoneNumber(),prod.getPassword(),prod.getConfirmPassword());
		Assert.assertEquals(mess, "Your Account Has Been Created!");
	}

}
