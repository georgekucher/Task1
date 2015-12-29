package com.cisco.vms.ta.task1.test_suite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cisco.vms.ta.task1.ui_model.GoogleSearchPage;

public class GoogleTest {
	private static final String BASEURL = "https://www.google.com.ua/webhp?hl=en";
	private static final int TIMEOUT = 10;
	private static final String SEARCH_PHRASE = "translate google com";
	private static final String SOURCE_WORD = "Apple";

	private static WebDriver driver;
	private static GoogleSearchPage googleSearchPage;

	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.get(BASEURL);
		googleSearchPage = new GoogleSearchPage(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

	@Test
	public void googleTranslateTest() {
		googleSearchPage.findTranslator(SEARCH_PHRASE);
		String result = googleSearchPage.translateTheWord(SOURCE_WORD);
		Assert.assertNotEquals("Tranlated text equals!", SOURCE_WORD, result);
	}
}