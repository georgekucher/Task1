package com.cisco.vms.ta.task1.test_suite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.cisco.vms.ta.task1.ui_model.GoogleSearchPage;

public class BaseTest {
	protected static final String BASEURL = "https://www.google.com.ua/webhp?hl=en";
	protected static final int TIMEOUT = 10;

	protected WebDriver driver;
	protected GoogleSearchPage googleSearchPage;

	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.get(BASEURL);
		googleSearchPage = new GoogleSearchPage(driver);
	}

	//@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
