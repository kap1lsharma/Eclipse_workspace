package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accPage = login.doLogin("Testselenium89@gmail.com", "qwerty");
	}

	@Test
	public void accPageTitleTest() {
		String actualTitle = accPage.accountPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.Account_PAGE_TITLE);
	}

	@Test
	public void logoutLinkExistsTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

	@Test
	public void accPageHeaderTest() {

		int AccountPageHeaders = accPage.getAccountsPageHeaderPageCount();
		System.out.println("Actual Account Headers Page : " + AccountPageHeaders);
		Assert.assertEquals(AccountPageHeaders, AppConstants.Account_PAGE_HEADERS_COUNT);
	}

	@Test
	public void accPageHeadersList() {

		List<String> accountsPageHeaderList = accPage.getAccountPageHeader();
		Assert.assertNotEquals(accountsPageHeaderList, AppConstants.EXPECTED_ACCOUNT_HEADERS_LIST);

	}

	@Test
	public void searchText() {

		accPage.doSearch("Macbook");

	}
}
