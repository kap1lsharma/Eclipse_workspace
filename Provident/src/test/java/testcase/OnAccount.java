package testcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPath;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import extentReport.ExtentReport;
import initilizeBrowser.Base;
import pageObjectmodel.AgencyPOM;
import sun.awt.SunHints.Value;
import utility.Excelutility;

public class OnAccount extends Base {

	public OnAccount() {
		super();
	}

	public WebDriver driver;

	AgencyPOM ag = new AgencyPOM(driver);
	Excelutility exceldata = new Excelutility();
	ExtentReport extentReport = new ExtentReport();

	@BeforeMethod
	public void Setup() throws Throwable {
		driver = initilizeBrowser(prop.getProperty("browserName"));
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);

	}

//	@AfterMethod
//	public void teardown() {
//		driver.quit();
//	}

	@Test
	public void ForOnAccount() throws IOException, InterruptedException {
		AgencyPOM ag = new AgencyPOM(driver);
		String excelFile = "src/test/resource/OnAccount.xlsx";
		String Agency = "Agency";
		int columnIndex = 2;
		FileInputStream fis = new FileInputStream(new File(excelFile));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(Agency);
		ag.ClickBroker();
		Iterator<Map.Entry<String, Map<String, String>>> iterator = exceldata.getAllDataInMap(excelFile, Agency)
				.entrySet().iterator();
		iterator.hasNext();
		Map.Entry<String, Map<String, String>> agent = iterator.next();
		ag.EnterNo(agent.getValue().get("BrokerNumber"));
		ag.ClickSearch();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//td[@class='BDT6AYB-y-a BDT6AYB-y-c BDT6AYB-y-d']")).click();
		Thread.sleep(2000);
		for (Row row : sheet) {
			if (row.getRowNum() == 0) {
				continue;
			}
			Cell cell = row.getCell(columnIndex);
			// Check if the cell is not empty
			if (cell != null) {
				// Assign the cell value to the brokerName variable
				String brokerName = cell.toString().trim();
				System.out.println(brokerName);
				// Find the WebElement with the dynamically assigned brokerName
				WebElement expectedName;
				try {
					expectedName = driver.findElement(By.xpath("//div[.='" + brokerName + "']"));
					// Compare and perform actions
					if (expectedName.getText().trim().equals(brokerName)) {
						expectedName.click();
						try {
							WebElement ifAccPage = driver.findElement(By.xpath(
									"(//a[@class='gwt-Anchor field'][string-length(normalize-space(text())) > 0])[2]"));
							if (ifAccPage.isDisplayed()) {
								Thread.sleep(2000);
								System.out.println("Account is already added for Agency:" +ifAccPage.getText());
								driver.navigate().back();
								Thread.sleep(2000);
							}
						} catch (org.openqa.selenium.NoSuchElementException e) {
							JavascriptExecutor js2 = (JavascriptExecutor) driver;
							// Taking name from agency section as Agent Name
							String agentName = driver.findElement(By.xpath("(//*[@id='name-readonly'])[1]")).getText();
							// Clicking on Add Account
							driver.findElement(By.xpath("(//div[@role='button'])[11]")).click();
							// -----Account Details Section On Account---
							Thread.sleep(1000);

							int yourAccNumColumnIndex = 3;
							int yourAccNameColumnIndex = 4;
							String accNum = row.getCell(yourAccNumColumnIndex).toString().trim();
							ag.EnterAgyAccNumber(accNum);

							String accName = row.getCell(yourAccNameColumnIndex).toString().trim();
							ag.EnterAgyAccName(accName);
							WebElement acctype = driver.findElement(By.xpath("//*[@id=\"account-type-button\"]"));
							acctype.click();
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							driver.findElement(By.xpath("//div[text()='Receivable']")).click();
							WebElement paymenttype = driver
									.findElement(By.xpath("//*[@id=\"payment-currency-button\"]"));
							paymenttype.click();
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							driver.findElement(By.xpath("//div[text()='New Zealand Dollars']")).click();
							// -------Terms Section On Account-------
							driver.findElement(By.id("credit-terms-days")).clear();
							driver.findElement(By.id("credit-terms-days")).sendKeys("0");
//									---------Account Reconciliation Section-------
							WebElement statement = driver
									.findElement(By.xpath("//*[@id=\"reconciliation-statement-method-button\"]"));
							statement.click();
							Thread.sleep(2000);
							driver.findElement(By.xpath("//div[text()='Email/Electronic']")).click();
							driver.findElement(By.xpath("//*[@id=\"reconciliation-statement-frequency-button\"]"))
									.click();
							driver.findElement(By.xpath("//div[text()='Monthly']")).click();
							driver.findElement(By.xpath("//*[@id=\"reconciliation-recipient-email\"]"))
									.sendKeys(agent.getValue().get("Recipient_Email"));
							// "Statement Day" for Account On
							driver.findElement(By.xpath("//*[@id=\"reconciliation-statement-day-button\"]")).click();
							driver.findElement(By.xpath("//*[text()='1']")).click();
							driver.findElement(By.xpath("//*[@id=\"statement-type-button\"]")).click();
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							driver.findElement(By.xpath("//div[text()='Transaction Statement']")).click();
							// -------Debit Receipt Details------------------
							driver.findElement(By.xpath("(//*[@id=\"settlement-method-button\"])[1]")).click();
							Thread.sleep(1500);
							js2.executeScript("arguments[0].click();",
									driver.findElement(By.xpath("//div[text()='On Account']")));

							// -----Credit Payment Details Section On Account-------
							driver.findElement(By.xpath("//*[@id='payment-frequency-button']")).click();
							Thread.sleep(1000);
							driver.findElement(By.xpath("(//div[text()='Monthly'])[2]")).click();
							Thread.sleep(1000);
							driver.findElement(By.xpath("//*[@id='payment-day-button']")).click();
							Thread.sleep(1000);
							driver.findElement(By.xpath("(//div[text()='1'])[2]")).click();
							Thread.sleep(1500);
							driver.findElement(By.xpath("(//*[@id='settlement-method-button'])[2]")).click();
							Thread.sleep(1500);
							js2.executeScript("arguments[0].click();",
									driver.findElement(By.xpath("(//div[text()='On Account'])[2]")));
							driver.findElement(By.xpath("//div[text()='Save']")).click();
							Thread.sleep(1500);
							
//							WebElement dupAccWarning = driver.findElement(By.xpath("//td[contains(text(), 'Please enter a unique Name / Number')]"));
							
							driver.findElement(By.xpath("//div[text()='Save']")).click();
							Thread.sleep(1500);
							driver.findElement(By.xpath("//div[text()='Exit']")).click();

							Thread.sleep(3000);
							driver.findElement(By
									.cssSelector("tr[__gwt_row=\"0\"] [class=\"BDT6AYB-y-a BDT6AYB-y-c BDT6AYB-y-d\"]"))
									.click();
						}
					} else {
						// Handle the case where data on the page is not present
						System.out.println("Data not present for brokerName: " + brokerName);
					}
				} catch (org.openqa.selenium.NoSuchElementException e) {
					// Handle the case where the WebElement for brokerName is not found
					System.out.println("WebElement not found for brokerName: " + brokerName);
				}
			}
		}

	}
}
