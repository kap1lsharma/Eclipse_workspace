package initilizeBrowser;

import java.util.Properties;
import java.io.*;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	
	public Base() {
		
		prop =new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\configuration\\config.properties");
		
		try {
		FileInputStream fil = new FileInputStream(propfile);
		prop.load(fil);
		} catch (Throwable e) {
			e.printStackTrace();
		}	
	}

	public WebDriver initilizeBrowser(String BrowserName) {
		
		if(BrowserName.equals("chrome")) {
			
			ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBrowserVersion("114");
			driver =new ChromeDriver();
				  
		}else if(BrowserName.equals("firefox"))	{
			
		   driver = new FirefoxDriver();
			
		}else if(BrowserName.equals("edge")) {
			
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}

}