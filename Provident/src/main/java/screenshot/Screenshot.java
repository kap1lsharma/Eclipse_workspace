package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

	 
public class Screenshot {
	
	
	public String captureScreen(String tName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String target = System.getProperty("user.dir") + "\\Screenshot\\" +tName+ ".png";
	    FileUtils.copyFile(source,new File(target));
		return target;
	}
	
}