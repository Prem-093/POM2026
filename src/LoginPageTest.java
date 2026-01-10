package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {
	
	@Test  (priority=2)
	public void testRegistrationLink()
	{
		boolean flag=login.isRegistrationLinkEnable();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test (priority=1)
	public void testTitleofSignupPage()
	{
		String title=login.doGetTitleofSignupPage();
		System.out.println(title);
		Assert.assertEquals(title, "Account Login");
	}
	
	
	

}
