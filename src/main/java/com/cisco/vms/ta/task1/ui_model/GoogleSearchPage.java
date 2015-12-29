package com.cisco.vms.ta.task1.ui_model;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
	private WebDriver driver;

	@FindBy(name = "q")
	private static WebElement searchInput;
	@FindBy(name = "btnG")
	private static WebElement searchButton;
	@FindBy(css = "div#ires h3.r a")
	private static List<WebElement> searchResults;
	@FindBy(id = "source")
	private static WebElement source;
	@FindBy(id = "gt-tl-gms")
	private static WebElement allLangsButton;
	@FindBy(css = "div#gt-tl-sugg div[aria-pressed='false']")
	private static List<WebElement> allLangs;
	@FindBy(id = "result_box")
	private static WebElement resultBox;

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

	public void inputSourceWord(String sourceWord) {
		source.sendKeys(sourceWord);
	}

	public void pickRandomLang() {
		Random rand = new Random();
		int i = rand.nextInt(allLangs.size() - 1);
		allLangs.get(i).click();
	}

	public String getResultText() {
		return resultBox.getText();
	}

	public void findTranslator(String searchPhrase) {
		fillSearchForm(searchPhrase);
		clickSearch();
		clickFirstResult();
	}

	public String translateTheWord(String sourceWord) {
		inputSourceWord(sourceWord);
		pickRandomLang();
		return getResultText();
	}
}