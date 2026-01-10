package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.Page.AccountPage;
import com.qa.opencart.base.BaseTest;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void  doLogin()
	{
		account=login.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test
	public void testAccountPageTitle()
	{
	String title=	account.doGetVerifyAccountTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Account Login");
	}
	
	
}
