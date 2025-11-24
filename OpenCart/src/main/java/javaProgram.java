import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaProgram {

	public static void main(String[] args) {

		
		//Webdriver is an interface that means methods are not implemented
       //driver is instance or reference, and this can be changed
		//ChromeDriver() is a class that uses implement the webdriver's methods using up casting
		
		
		WebDriver driver = new ChromeDriver();
	 
		
		
		driver.get("https://www.flipkart.com/");
		
		
		driver.manage().window().maximize();
		List<WebElement> Values = driver.findElements(By.xpath("//span[@class='_1XjE3T']"));
		System.out.print(Values + " ");

		for (WebElement products : Values) {
			String productName = products.getText();
			System.out.println(productName);
		}
		
	 

	}

}
