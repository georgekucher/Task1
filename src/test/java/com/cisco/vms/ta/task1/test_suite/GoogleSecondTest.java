package com.cisco.vms.ta.task1.test_suite;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSecondTest extends BaseTest {
	private static final String SEARCH_WORD = "Apple";

	@Test
	public void testGoogleSecond() {
		googleSearchPage.googleSearch(SEARCH_WORD);
		int n = googleSearchPage.getNumberOfResults();
		for (int i = 2; i < 11; i += 8) {
			googleSearchPage.clickPage(i);
			int j = googleSearchPage.getNumberOfResults();
			Assert.assertEquals(j, n,
					String.format("Number of search results at page %d is not the same as at first page:", i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}