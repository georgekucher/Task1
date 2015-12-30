package com.cisco.vms.ta.task1.ui_model;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleTranslator extends BasePage {

	@FindBy(id = "source")
	private WebElement source;
	@FindBy(id = "gt-tl-gms")
	private WebElement allLangsButton;
	@FindBy(css = "div#gt-tl-sugg div[aria-pressed='false']")
	private List<WebElement> allLangs;
	@FindBy(id = "result_box")
	private WebElement resultBox;

	public GoogleTranslator(WebDriver driver) {
		super(driver);
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

	public String translateTheWord(String sourceWord) {
		inputSourceWord(sourceWord);
		pickRandomLang();
		return getResultText();
	}
}
