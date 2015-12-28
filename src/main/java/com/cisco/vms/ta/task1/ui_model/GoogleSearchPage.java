package com.cisco.vms.ta.task1.ui_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
	private WebDriver driver;
	
	@FindBy(name = "q")
	private static WebElement searchInput;

	@FindBy(name = "btnK")
	private static WebElement searchButton;
	
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillSearchForm(String searchPhrase) {
		searchInput.sendKeys(searchPhrase);
	}
	
	public void clickSearch() {
		searchButton.click();
	}
}
