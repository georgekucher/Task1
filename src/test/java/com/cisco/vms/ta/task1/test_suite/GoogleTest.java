package com.cisco.vms.ta.task1.test_suite;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
	private static final String SEARCH_PHRASE = "translate google com";
	private static final String SOURCE_WORD = "Apple";

	@Test
	public void testGoogleTranslate() {
		String result = googleSearchPage.findTranslator(SEARCH_PHRASE).translateTheWord(SOURCE_WORD);
		Assert.assertNotEquals(result, SOURCE_WORD, "Translated text equals!");
	}
}