package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleutil;

	private By logoutButton = By.linkText("Logout");
	private By accountHeaders = By.cssSelector("#content >h2");
	private By search = By.cssSelector("#search >input");
	private By searchIcon = By.cssSelector("div#search button");

	public AccountPage(WebDriver driver) {

		this.driver = driver;
		eleutil = new ElementUtil(driver);

	}

	public String accountPageTitle() {

		return eleutil.waitForTitleIs(AppConstants.Account_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);

	}

	public Boolean isLogoutLinkExist() {

		return eleutil.waitForElementPresence(logoutButton, AppConstants.SHORT_TIME_OUT).isDisplayed();

	}

	public List<String> getAccountPageHeader() {

		List<WebElement> Headerlist = eleutil.waitForElementsVisible(accountHeaders, AppConstants.SHORT_TIME_OUT);
		List<String> headerValueList = new ArrayList<String>();
		for (WebElement e : Headerlist) {
			String headers = e.getText();
			headerValueList.add(headers);
		}

		System.out.println("Account Page Header ===>" + headerValueList);
		return headerValueList;

	}

	public int getAccountsPageHeaderPageCount() {
		return eleutil.waitForElementsVisible(accountHeaders, AppConstants.SHORT_TIME_OUT).size();
	}

	public SearchResultPage doSearch(String searchkey) {

		eleutil.waitForElementVisible(search, AppConstants.MEDIUM_TIME_OUT).sendKeys(searchkey);
		return new SearchResultPage(driver);//TDD
	}

}
