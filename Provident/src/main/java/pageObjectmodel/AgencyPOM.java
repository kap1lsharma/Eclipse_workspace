package pageObjectmodel;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgencyPOM {

	public WebDriver driver;
	Properties prop;

	@FindBy(xpath = "//td[text()='Broker']")
	private WebElement Broker;

	@FindBy(id = "name")
	private WebElement BrokerName;

	@FindBy(xpath = "//div[text()='Search']")
	private WebElement Search;

	@FindBy(xpath = "//tr[@class='BDT6AYB-y-b']")
	private WebElement Table;

	@FindBy(xpath = "//a[@class='gwt-Anchor field']")
	private WebElement HeadOffice;

	@FindBy(id = "broker-number")
	private WebElement BrokerNumber;

	@FindBy(id = "type-button")
	private WebElement Type;

	@FindBy(id = "vat-registration-number")
	private WebElement GST;

	@FindBy(id = "account-number")
	private WebElement AgencyAccNumber;

	@FindBy(id = "account-name")
	private WebElement AgencyAccName;

	@FindBy(id = "bank-account-name")
	private WebElement BankAccName;

	@FindBy(id = "bank-number")
	private WebElement BankNum;

	@FindBy(id = "bank-account-number")
	private WebElement BankAccNum;

	@FindBy(id = "branch-number")
	private WebElement BranchNum;

	@FindBy(id = "suffix")
	private WebElement Suffix;

	@FindBy(id = "credit-terms-days")
	private WebElement CreditTermsDays;

	@FindBy(id = "bank-name")
	private WebElement BankName;

	@FindBy(xpath = "(//input[@type='text' and contains(@class, 'gwt-TextBox') and contains(@class, 'BDT6AYB-g-b') and contains(@class, 'BDT6AYB-g-d') and @autocomplete='off' and @style='width: 30em;'])[3]")
	private WebElement Address;

	public AgencyPOM(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickBroker() {
		Broker.click();
	}

	public void EnterNo(String No) {
		BrokerNumber.clear();
		BrokerNumber.sendKeys(No);
	}

	public void ClickSearch() {
		Search.click();
	}

	public void ClickTable() {
		Table.click();
	}

	public void ClickHeadOffice() {
		HeadOffice.click();
	}

	public void EnterBrokerNum(String Num) {
		BrokerNumber.sendKeys(Num);
	}

	public void EnterGST(String num) {
		GST.sendKeys(num);
	}

	public void EnterAgyAccNumber(String num) {
		AgencyAccNumber.sendKeys(num);
	}

	public void EnterAgyAccName(String num) {
		AgencyAccName.sendKeys(num);
	}

	public void EnterBankAccName(String num) {
		BankAccName.sendKeys(num);
	}

	public void EnterBankNum(String num) {
		BankNum.sendKeys(num);
	}

	public void EnterBankAccNum(String num) {
		BankAccNum.sendKeys(num);
	}

	public void EnterBranchNum(String num) {
		BranchNum.sendKeys(num);
	}

	public void EnterSuffix(String num) {
		Suffix.sendKeys(num);
	}

	public void EnterCreditTermsDays(CharSequence[] num) {
		CreditTermsDays.sendKeys(num);
		;
	}

	public void EnterBankName(String Name) {
		BankName.sendKeys(Name);
	}

	public void EnterAddress(String Add) {
		Address.sendKeys(Add);
	}
}
