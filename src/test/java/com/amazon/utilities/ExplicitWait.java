package com.amazon.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public static void visibiltyOfElementLocated(WebElement ele) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}

}
