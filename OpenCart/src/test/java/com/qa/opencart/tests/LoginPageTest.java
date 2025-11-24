package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority = -13434)
	public void loginPageTitle() {

		String actualTitle = login.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);

	}

	@Test(priority = 1)
	public void loginPageURL() {

		String Actualurl = login.getCurrentURL();
		Assert.assertTrue(Actualurl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));

	}

	@Test(priority = 2)
	public void isForgotPwdLinkDisplayed() {

		Assert.assertTrue(login.isForgetPwdDisplayed());

	}

	@Test(priority = 3)
	public void LoginTest() {

		accPage = login.doLogin("Testselenium89@gmail.com", "qwerty");
		Assert.assertEquals(accPage.isLogoutLinkExist(), true);

	}

}
