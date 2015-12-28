package com.cisco.vms.ta.task1.ui_model;

import java.util.List;

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
	@FindBy(className = "r")
	private static List<WebElement> searchResults;
	@FindBy(id = "source")
	private static WebElement source;
	
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
	
	public void clickFirstResult() {
		searchResults.get(0).click();
	}
}
