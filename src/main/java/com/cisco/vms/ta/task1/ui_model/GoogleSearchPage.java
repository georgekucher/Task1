package com.cisco.vms.ta.task1.ui_model;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage {

	@FindBy(name = "q")
	private WebElement searchInput;
	@FindBy(name = "btnG")
	private WebElement searchButton;
	@FindBy(css = "div#ires h3.r a")
	private List<WebElement> searchResults;
	@FindBy(css = "table#nav td")
	private List<WebElement> pages;

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
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

	public int getNumberOfResults() {
		return searchResults.size();
	}

	public void clickPage(int i) {
		pages.get(i).click();
	}

	public void googleSearch(String searchPhrase) {
		fillSearchForm(searchPhrase);
		clickSearch();
	}

	public GoogleTranslator findTranslator(String searchPhrase) {
		googleSearch(searchPhrase);
		clickFirstResult();
		return new GoogleTranslator(driver);
	}
}