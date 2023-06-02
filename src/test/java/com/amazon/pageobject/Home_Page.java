package com.amazon.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.utilities.ExplicitWait;

public class Home_Page {
	
WebDriver driver;
WebDriverWait wait;
	
	public Home_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

	@FindBy(how=How.ID, using="nav-link-accountList-nav-line-1")
	WebElement Sign;
	
	@FindBy(how=How.ID, using="nav-logo-sprites")
	WebElement Amazon_logo;
	
	public void click_Signin() {
		Sign.click();
	}
	
	public void checkLogo() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		
		wait.until(ExpectedConditions.visibilityOf(Amazon_logo));
		
	}
}
