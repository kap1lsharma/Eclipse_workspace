package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class Checkout {

	private WebDriver driver;
	private ElementUtil eleutil;
	private By PickUp = By.xpath("//p[text()='Pick Up']");
	private By pickUp2 = By.xpath("//button[@data-testid='selectedPickUpMode0']");
	private By ContinueButton = By.xpath("//button[text()='Continue']");
	private By AddToCartButton = By.xpath("//button[text()=' add to cart ']");
	private By ClickOnCart = By.xpath("//*[@id='cart-header']/div");
	private By CheckoutButton = By.xpath("//button[text()='Checkout']");
	private By GuestLogin = By.xpath("//button[@data-testid='guestLogin']");

	private By FirstName = By.xpath("(//input[@data-testid='first_name'])[2]");
	private By LastName = By.xpath("(//input[@data-testid='last_name'])[2]");
	private By Phone = By.xpath("(//input[@data-testid='phone'])[2]");
	private By EmailID = By.xpath("(//input[@name='email'])[2]");
	private By FormContinueButton = By.xpath("((//button[text()='Continue']))[3]");
	private By FinalContinueButton = By.xpath("((//button[text()='Continue']))[2]");

	public Checkout(WebDriver driver) {

		this.driver = driver;
		eleutil = new ElementUtil(driver);

	}

	public void PickUpTheOrder() {

		eleutil.clickElementWhenReady(PickUp, 2);
		eleutil.clickElementWhenReady(pickUp2, 2);

	}

	public void DoClickOnContinue() throws InterruptedException {

		Thread.sleep(2000);
 
		eleutil.clickElementWhenReady(ContinueButton, 2);

	}

	public void selectProduct(String product) {

		By chooseProduct = By.xpath("//h5[text()='" + product + "']");
		eleutil.clickElementWhenReady(chooseProduct, 4);

	}

	public void ClickOnCart() {

		driver.navigate().back();
		eleutil.clickElementWhenReady(ClickOnCart, 2);

	}

	public void AddToCart() {

		eleutil.clickElementWhenReady(AddToCartButton, 2);

	}

	public void checkout() {

		eleutil.clickElementWhenReady(CheckoutButton, 2);

	}

	public void guestLogin() {

		eleutil.clickElementWhenReady(GuestLogin, 2);

	}

	public void addCustDetails(String fName, String lName, String phoneNum, String email) {

		eleutil.waitForElementAndEnterValue(FirstName, 5, 1, fName);
		eleutil.waitForElementAndEnterValue(LastName, 5, 1, lName);
		eleutil.waitForElementAndEnterValue(Phone, 5, 1, phoneNum);
		eleutil.waitForElementAndEnterValue(EmailID, 5, 1, email);

	}

	public void formContinue() {

		eleutil.clickElementWhenReady(FormContinueButton, 2);

	}

	public void finalContinue() throws InterruptedException {

		Thread.sleep(2000);
		eleutil.clickElementWhenReady(FinalContinueButton, 5);

	}

}
