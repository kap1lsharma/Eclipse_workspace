package PlaywrightDemo;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PLaywrightTest {

	public static void main(String[] args) throws InterruptedException {
 
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

		Page page = context.newPage();
		page.navigate("https://www.google.com");

		System.out.println("Page title is : " + page.title());
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/example.png")));
		Thread.sleep(10000);
		browser.close();
		playwright.close();
		
	
		

	}

}
