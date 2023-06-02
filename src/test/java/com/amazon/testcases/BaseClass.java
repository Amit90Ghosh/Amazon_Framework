package com.amazon.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.amazon.utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	
	ReadConfig readconfig = new ReadConfig();
	public String BaseURL = readconfig.getURL();
	public String uname = readconfig.getUsername();
	public String pass = readconfig.getPassword();
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		}
		else if(br.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		logger = Logger.getLogger("Amazon");
		PropertyConfigurator.configure("log4j2.properties");
	}
	
    @AfterClass
	public void teardown() {
		driver.quit();
	}
}
