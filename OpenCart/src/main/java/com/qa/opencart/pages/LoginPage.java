package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// private page locator
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By LoginButton = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	 
	


	// public page constructor
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// public page actions/methods
	public String getLoginPageTitle() {

		String PageTitle = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		System.out.println("Page Title is : " + PageTitle);
		return PageTitle;

	}

	public String getCurrentURL() {

		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_TIME_OUT);
		System.out.println("Page URL is : " + url);
		return url;

	}

	public boolean isForgetPwdDisplayed() {

		return eleUtil.waitForElementVisible(forgotPwdLink, AppConstants.MEDIUM_TIME_OUT).isDisplayed();

	}

	public AccountPage doLogin(String username, String pwd) {

		System.out.println("App Cred are : " + username + " : " + pwd);
		eleUtil.waitForElementVisible(email, AppConstants.MEDIUM_TIME_OUT).sendKeys(username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(LoginButton);
		return new AccountPage(driver);

	}
}
