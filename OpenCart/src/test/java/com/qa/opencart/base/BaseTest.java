package com.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	WebDriver driver;
	protected LoginPage login;
	protected AccountPage accPage;

//	protected Checkout checkout;

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//		driver.get("https://restolabsdemo.onlineordering.io/en/order");
		login = new LoginPage(driver);
//		checkout = new Checkout(driver);

	}

//	@AfterTest
//	public void teardown() {
//		driver.quit();
//
//	}

}
