package com.amazon.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login_page {

	WebDriver driver;
	
	public Login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using ="ap_email")
	WebElement username;
	
	@FindBy(how=How.ID, using ="continue")
	WebElement continueButton;
	
	@FindBy(how=How.ID, using="ap_password")
	WebElement password;
	
	@FindBy(how=How.ID, using="signInSubmit")
	WebElement signInButton;
	
	public void enterUsername(String uname) {
		username.click();
		username.sendKeys(uname);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickContinue() {
		continueButton.click();
	}

	public void clickSignIn() {
		signInButton.click();
		}
	
	}
