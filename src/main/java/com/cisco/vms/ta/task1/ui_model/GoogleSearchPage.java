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

	public GoogleTranslator findTranslator(String searchPhrase) {
		fillSearchForm(searchPhrase);
		clickSearch();
		clickFirstResult();
		return new GoogleTranslator(driver);
	}
}