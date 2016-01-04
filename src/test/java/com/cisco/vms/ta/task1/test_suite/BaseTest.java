package com.cisco.vms.ta.task1.test_suite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cisco.vms.ta.task1.ui_model.GoogleSearchPage;

public class BaseTest {
	protected static final String BASEURL = "https://www.google.com.ua/webhp?hl=en";
	protected static final int TIMEOUT = 10;
	protected static final String GROUP_NAME = "translators";

	protected WebDriver driver;
	protected GoogleSearchPage googleSearchPage;

	@BeforeClass(groups = { GROUP_NAME })
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.get(BASEURL);
		googleSearchPage = new GoogleSearchPage(driver);
	}

	@AfterClass(groups = { GROUP_NAME })
	public void tearDown() {
		driver.quit();
	}
}
