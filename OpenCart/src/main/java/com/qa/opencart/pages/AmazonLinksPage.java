package com.qa.opencart.pages;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AmazonLinksPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By pageLinks = By.tagName("a");

	public AmazonLinksPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil = new ElementUtil(driver);
	}

	// Method to check if links are broken
	public List<String> checkBrokenLinks() {
		List<String> brokenLinks = new ArrayList<>();
		List<WebElement> links = driver.findElements(pageLinks);

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			if (url != null && !url.isEmpty()) {
				try {
					HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
					connection.setRequestMethod("HEAD");
					connection.connect();

					int responseCode = connection.getResponseCode();
					if (responseCode >= 400) {
						brokenLinks.add(url + " - Broken (Status: " + responseCode + ")");
					}
				} catch (Exception e) {
					System.out.println("Exception while checking link: " + url);
					brokenLinks.add(url + " - Exception occurred");
				}
			} else {
				System.out.println("Empty or missing URL for element: " + link.getText());
			}
		}
		return brokenLinks;
	}
}