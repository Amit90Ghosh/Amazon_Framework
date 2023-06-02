package com.amazon.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.pageobject.Home_Page;
import com.amazon.pageobject.Login_page;



public class TC_Login_001 extends BaseClass{
	
	@Test
	public void TC_001() {
		
		driver.get(BaseURL);
		
		logger.info("URL open");
		
		Home_Page HP = new Home_Page(driver);
		
		HP.click_Signin();
		
		Login_page LP = new Login_page(driver);
		
		LP.enterUsername(uname);
		
		logger.info("username entered");
		
		LP.clickContinue();
		
		LP.enterPassword(pass);
		
		logger.info("password entered");
		
		LP.clickSignIn();
		
		HP.checkLogo();
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
		{
			logger.info("TC passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.info("TC failed");
			Assert.assertTrue(false);
			
		}
	}

}
