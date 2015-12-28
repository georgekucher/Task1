package com.cisco.vms.ta.task1.test_suite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest {
	private static final String BASEURL = "https://www.google.com.ua/webhp?hl=en";
    private static final int TIMEOUT = 10;
    private static final String SEARCH_PHRASE = "translate google com";
	
    private static WebDriver driver;
	

	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.get(BASEURL);
	}
	
	//@AfterClass
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void searchSuggestionTest() {
		
	}
}